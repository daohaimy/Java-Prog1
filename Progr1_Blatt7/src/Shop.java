public class Shop {
    public static void main(String[] args) {
        EinUndAusgabe ea = new EinUndAusgabe();
        System.out.print("Buchpreis: ");
        double buchPreis = ea.leseDouble();
        System.out.print("DVD-Preis: ");
        double dvdPreis = ea.leseDouble();
        Haendler buchHaendler = new Haendler(buchPreis);
        Haendler dvdHaendler = new Haendler(dvdPreis);
        String weiter;
        int anzahlBuch = 0;
        int anzahlDvd = 0;

        do {
            System.out.print("Buch oder DVD kaufen (b/d)?");
            String auswahl = ea.leseString();
            System.out.print("Anzahl Produkte");
            int anzahl = ea.leseInteger();
            if (auswahl.equals("b")) {
                anzahlBuch = anzahlBuch + anzahl;
                buchHaendler.kaufen(anzahlBuch);
            } else {
                anzahlDvd = anzahlDvd + anzahl;
                dvdHaendler.kaufen(anzahlDvd);
            }
            System.out.println("weiter einkaufen(j/n): ");
            weiter = ea.leseString();
        } while (weiter.equals("j"));
        double einnahmen = buchHaendler.liefereEinnahmen();
        System.out.println("Einnahmen des Buchhaendlers = " + einnahmen);
        einnahmen = dvdHaendler.liefereEinnahmen();
        System.out.println("Einnahmen des DVD-Haendlers = " + einnahmen);
    }
}