import java.util.ArrayList;

public class Bank {
    ArrayList<Konto> konten;

    public Bank() {
        konten = new ArrayList<>();
    }

    public Konto erstelleKonto() {
        Konto neuesKonto = new Konto();

        konten.add(neuesKonto);
        return neuesKonto;
    }

    public void erstelleKonto(int anzahl) {
        for(int n = 0; n < anzahl; n++) {
            erstelleKonto();
        }
    }

    public Konto sucheKonto(int kto) {
        for(Konto k : konten) {
            if(k.getKontonummer() == kto) {
                return k;
            }
        }

        return null;
    }

    public boolean auszahlen(Konto konto, double betrag) {
        return konto.auszahlen(betrag);
    }

    public boolean auszahlen(int kto, double betrag) {
        Konto konto = this.sucheKonto(kto);

        if(konto != null) {
            return konto.auszahlen(betrag);
        }

        return false;
    }
}
