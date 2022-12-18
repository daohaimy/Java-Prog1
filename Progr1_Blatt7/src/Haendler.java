import java.util.logging.Handler;

public class Haendler {
    double preis;
    int anzahl;

    public Haendler(double preis){
        this.preis = preis;
    }

    public int kaufen(int anzahl){
        return this.anzahl = anzahl;
    }

    public double liefereEinnahmen(){
        return kaufen(anzahl) * preis;
    }
}
