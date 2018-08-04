package restauracja;

//listy
import java.util.ArrayList;
import java.util.List;

public class Stolik {
    
    List<Produkt> rachunek = new ArrayList<Produkt>();
    
    // stolik info
    int numer = 0;
    int ilosc_miejsc = 0;
    String kelner = "obecnie brak kelnera";
    String info = "brak info";
    
    // goście info
    int ilosc_gosci = 0;
    int suma_rachunku = 0;
    
    Stolik(int numer) {
        this.numer = numer;
    }
    
    Stolik(int numer, String kelner) {
        this.numer = numer;
        this.kelner = kelner;
    }
    
    Stolik(int numer, String kelner, String info) {
        this.numer = numer;
        this.kelner = kelner;
        this.info = info;
    }
    
    void pokazInfo() {
        System.out.println("\nNumer: " + this.numer);
        System.out.println("Kelner: " + this.kelner);
        System.out.println("Info: " + this.info);
    }
    
    void wypiszRachujek() {
        pokazInfo();
        System.out.println("Rachunek: ");
        for(int i=0; i < rachunek.size(); i++) {
            System.out.println("\t" + rachunek.get(i).wypisz());
        }
        System.out.println("Suma: " + this.suma_rachunku + "\n");
    }
    
    void dodajProdukt(String nazwa, int ilosc, String info) {
        Produkt p = (Produkt) Restauracja.karta.get(nazwa);
        p.ile(ilosc);
        p.info(info);
        rachunek.add(p);
        this.sumuj(p.cena * p.ilosc);
    }
    
    void sumuj(int cena) {
        this.suma_rachunku += cena;
    }
    
}
