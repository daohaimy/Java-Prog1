
public class Rechentest {
    void starte(){
        double naechsten30Downloads = 0.2;
        double nach30Downloads = 0.15;
        double kostenNaechsten30Downloads = naechsten30Downloads * 30;

        EinUndAusgabe eingabe = new EinUndAusgabe();
        System.out.println("Anzahl an gewünschten Downloads: ");
        int Musikstuecke = eingabe.leseInteger();
        if(Musikstuecke <= 5){
            System.out.println("Musikstuecke: " + Musikstuecke);
            System.out.println("Gebuehren = 0 Euro");
            System.out.println("Sie kriegen es kostenlos hehe");
        }
        if(Musikstuecke > 5 && Musikstuecke <= 35){
            System.out.println("Musikstuecke: " + Musikstuecke);
            naechsten30Downloads = naechsten30Downloads * (Musikstuecke - 5);
            System.out.println("Gebuehren = " + naechsten30Downloads + " Euro");
        }
        if(Musikstuecke > 35){
            System.out.println("Musikstuecke: " + Musikstuecke);
            nach30Downloads = nach30Downloads * (Musikstuecke - 35);
            double nach30Downloaden = kostenNaechsten30Downloads + nach30Downloads;
            String nach30DownloadenString = String.format("%.02f", nach30Downloaden);
            System.out.println("Gebuehren = " + nach30DownloadenString + " Euro");
        }
    }
}
