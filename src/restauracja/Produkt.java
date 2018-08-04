package restauracja;

public class Produkt {
    
    String nazwa;
    int cena;
    int ilosc;
    String info = "";
    
    Produkt(String nazwa, int cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }
    
    void ile(int ilosc) {
        this.ilosc = ilosc;
    }
    
    void info(String info) {
        this.info = info;
    }
    
    String wypisz() {
        return this.nazwa + " | Ilość: " + this.ilosc + " | Cena razem: " + this.cena*this.ilosc + " | Info: " + this.info;
    }
    
}
