import java.util.Objects;
public class Konto {
    int kontonummer;
    String kontoinhaber;
    double aktuellenKontostand;
    double kreditrahmen = 0.0;

    public Konto(int kontonummer, String kontoinhaber, double aktuellenKontostand, double kreditrahmen){
        this.kontonummer = kontonummer;
        this.kontoinhaber = kontoinhaber;
        this.aktuellenKontostand = aktuellenKontostand;
        this.kreditrahmen = kreditrahmen;
    }

    public Konto(Konto konto){
        this.kontonummer = konto.kontonummer;
        this.kontoinhaber = konto.kontoinhaber;
        this.aktuellenKontostand = konto.aktuellenKontostand;
        this.kreditrahmen = konto.kreditrahmen;
    }

    public int getKontonummer(){
        return this.kontonummer;
    }
    public String getKontoinhaber(){
        return this.kontoinhaber;
    }


    public boolean vergleichen (Object obj){
        return this.aktuellenKontostand == ((Konto) obj).aktuellenKontostand;
    }

    public String aktuellenKontostand(int aktuellenKontostand){
        return Double.toString(aktuellenKontostand);
    }

    public void einzahlen(double einzahlen){
        this.aktuellenKontostand = aktuellenKontostand + einzahlen;
        if(aktuellenKontostand > 10000.00){
            aktuellenKontostand = aktuellenKontostand - (aktuellenKontostand-10000);
            this.kreditrahmen = 3000.0;
            System.out.println("Ihr aktueller Kontostand ist: " + this.aktuellenKontostand);
            System.out.println("Ihr Kreditrahmen ist: " + this.kreditrahmen);
        }
        else {
            System.out.println("Ihr aktueller Kontostand ist: " + this.aktuellenKontostand);
        }
    }

    public double abhebenGeldbetrag(double abheben){
        if(this.aktuellenKontostand > abheben) {
            return this.aktuellenKontostand = this.aktuellenKontostand - abheben;
        }
        else {
            System.out.println("Sie haben nicht genug Geld");
            return aktuellenKontostand;
        }
    }
    public double getAktuellenKontostand(){
        return this.aktuellenKontostand;
    }
    public void ueberweisen(Object obj, double geldUeberweisen){
        if(this.aktuellenKontostand > geldUeberweisen) {
            ((Konto) obj).aktuellenKontostand = ((Konto) obj).aktuellenKontostand + geldUeberweisen;
        }
        else {
            System.out.println("Sie haben nicht genug Geld");
        }
    }
}
