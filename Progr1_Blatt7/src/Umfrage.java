import java.util.ArrayList;

public class Umfrage {
    public static void main(String[] args) {
        EinUndAusgabe ea = new EinUndAusgabe();

        ArrayList<String> umfrage = new ArrayList<>();

        System.out.println("Titel der Umfrage: Grundl-Java-Umfrage");
        System.out.println("Anzahl Fragen: ");
        int anzahlFragen = ea.leseInteger();
        int[] jaSammeln = new int[anzahlFragen-1];
        int[] neinSammeln = new int[anzahlFragen-1];
        for(int i = 1; i < anzahlFragen + 1; i++){
            System.out.println("Frage " + i + " ");
            String frage = ea.leseString();
            umfrage.add(i-1, frage);
        }
        System.out.println("Umfrage");
        System.out.println("-------------");

        String teilnehmer;
        String antwort;
        int antwortJa = 0;
        int antwortNein = 0;
        int summeAntwort = 0;
        System.out.println("Weiterer Teilnehmer (j/n)? ");
        teilnehmer = ea.leseString();
        while(teilnehmer.equals("j")){
                for(int i = 1; i < anzahlFragen + 1; i++) {

                    System.out.println(umfrage.get(i-1));
                    System.out.println("ja/nein (j/n)");
                    antwort = ea.leseString();
                    if (antwort.equals("j")){
                        antwortJa++;
                        summeAntwort++;
                    }
                    else {
                        antwortNein++;
                        summeAntwort++;
                    }
                }
            System.out.println("Weiterer Teilnehmer (j/n)? ");
            teilnehmer = ea.leseString();
        }
        System.out.println("Umfrageergebnisse");
        System.out.println("-------------");
        System.out.println("Umfrage: Grundl-Java-Umfrage");
        if(summeAntwort > 0) {
            for (int i = 1; i < anzahlFragen + 1; i++) {
                System.out.println(umfrage.get(i - 1));
                double prozentJa = antwortJa * 100 / summeAntwort;
                System.out.println("Ja-Antworten: " + antwortJa + " = " + prozentJa + "%");
                double prozentNein = antwortNein * 100 / summeAntwort;
                System.out.println("Nein-Antworten: " + antwortNein + " = " + prozentNein +"%");
            }
        }
        else {
                System.out.println("noch keiner Teilnehmer hat die Umfrage gemacht!");
            }
    }
}
