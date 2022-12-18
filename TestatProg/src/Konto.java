public class Konto {
    static int ktoZaehler = 100;
    static final double DISPO = -1000.0;

    int kontonummer;
    double kontostand;

    static int generiereNeueKontonummer() {
        int neueNummer;

        neueNummer = ktoZaehler;
        ktoZaehler++;
        return  neueNummer;
    }

    public Konto() {
        kontonummer = generiereNeueKontonummer();
        kontostand = 0.0;
    }

    public Konto(double kontostand) {
        kontonummer = generiereNeueKontonummer();
        this.kontostand = kontostand;
    }

    public Konto(Konto konto) {
        this.kontonummer = konto.kontonummer;
        this.kontostand = konto.kontostand;
    }

    //An dieser Stelle lassen wir den setter weg,
    //weil wir nicht mÃ¶chten, dass die KTO von auÃŸer verÃ¤ndert werden kann
   /* public void setKontonummer(int kontonummer) {
        this.kontonummer = kontonummer;
    }*/

    public int getKontonummer() {
        return this.kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public boolean equals(Konto konto) {
        if(this.kontonummer == konto.kontonummer && this.kontostand == konto.kontostand) {
            return true;
        }

        return false;
    }

    public boolean auszahlen(double betrag) {
        if(kontostand - betrag >= DISPO) {
            kontostand = kontostand - betrag;
            return true;
        }

        return false;
    }
}
