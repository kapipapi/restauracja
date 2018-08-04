package restauracja;

import java.util.*;
import java.io.*;

public class Restauracja {

    static Dictionary karta = new Hashtable();
    static List<Stolik> sala = new ArrayList<Stolik>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        wczytajKarte();

        String komenda = " ";

        do {
            System.out.println("\n- :) -");
            System.out.println("stolik - tworzenie nowego stolika");
            System.out.println("dodaj - dodawanie produktu do stolika");
            System.out.println("pokaz - Pokaż stolik");
            System.out.println("wyjdz - Opuść baze");

            komenda = scan.nextLine();

            String[] czesci = komenda.split(" ");

            switch (czesci[0]) {
                case "stolik":
                    try {
                        int numer = sala.size() + 1;
                        String kelner = czesci[1];
                        String info = "";
                        for (int i = 2; i < czesci.length; i++) {
                            info += czesci[i];
                            info += " ";
                        }
                        sala.add(new Stolik(numer, kelner, info));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\n Komenda stolik potrzebuje dodatkowych informacji");
                        System.out.println("stolik *imie kelnera* *info*");
                    }
                    break;
                case "dodaj":
                    try {
                        int numer = Integer.parseInt(czesci[1]);
                        String nazwaDania = czesci[2];
                        int ilosc = Integer.parseInt(czesci[3]);
                        String info = "";
                        for (int i = 4; i < czesci.length; i++) {
                            info += czesci[i];
                            info += " ";
                        }
                        sala.get(numer - 1).dodajProdukt(nazwaDania, ilosc, info);
                    } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                        System.out.println("\n Komenda dodaj potrzebuje dodatkowych informacji.");
                        System.out.println("dodaj *nr stolika* *nazwa produktu* *ilosc* *info*");
                    } catch (NullPointerException e) {
                        System.out.println("\n Podano błędną nazwę produktu.");
                    }
                    break;
                case "pokaz":
                    try {
                        if (czesci.length == 1) {
                            pokazStoliki();
                        } else if (czesci.length == 2) {
                            int numer = Integer.parseInt(czesci[1]);
                            sala.get(numer - 1).wypiszRachujek();
                        } else {
                            System.out.println("Podano niepoprawną komendę.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Podano błędny numer stolika.");
                    }
                    break;
                case "wyjdz":
//                    zapiszBaze();
                    break;
                default:
                    System.out.println("Podano niepoprawną komendę.");
                    break;
            }

        } while (!komenda.equals("wyjdz"));

    }

    public static void wczytajKarte() throws FileNotFoundException, IOException {

        FileReader fileReader = new FileReader("baza.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String textLine = bufferedReader.readLine();
            do {
                String[] czesci = textLine.split(" ");
                karta.put(czesci[0], new Produkt(czesci[0], Integer.parseInt(czesci[1])));
                textLine = bufferedReader.readLine();
            } while (textLine != null);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Wczytana baza jest pusta.");
        } finally {
            bufferedReader.close();
            System.out.println("Wczytano kartę.");
        }

    }

    public static void pokazStoliki() {
        for (int i = 0; i < sala.size(); i++) {
            sala.get(i).pokazInfo();
        }
    }
}
