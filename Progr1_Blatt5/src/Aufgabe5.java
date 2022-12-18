import java.util.Scanner;

/*public class Aufgabe5 {
    public static String[] aufgabe5() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Wählen sie die Anzahl an Städten: ");
        int anzahlStadte = scanner.nextInt();

        String[] stadte = new String[anzahlStadte];
        for (int i = 0; i < anzahlStadte; i++) {
            System.out.println("Geben sie verschiedene Städte ein: ");
            stadte[i] = scanner.next();
        }

        System.out.println("Wie viele Direktverbindungen gibt es: ");
        int direkt = scanner.nextInt();

        String[] start = new String[direkt];
        for (int i = 0; i < direkt; i++) {
            System.out.println("wähle ein start");
            start[i] = scanner.next();
            String[] ende = new String[direkt];
            for (int n = 1; n < direkt; n++){
                System.out.println("wähle ein ende");
                ende[n] = scanner.next();
            }
            return ende;
        }
        return start;
//  erstell mal variablen für abfahrt und ankunft und weise denen direkt verbindungen zu

        // dann soll der User 2 stadte eingeben und das programm schaut ob es eine verbindung gibt


 */

import java.util.Arrays;
import java.util.ArrayList;

public class Aufgabe5 {


    EinUndAusgabe eingabe = new EinUndAusgabe();

    void starte() {
        System.out.println("Anzahl Städte: ");
        int i = 0;
        int anzahlStaedte = eingabe.leseInteger();
        String[] staedte = new String[anzahlStaedte];
        while (i < anzahlStaedte) {
            i = i + 1;
            System.out.println("Stadt: " + i);
            String stadt = eingabe.leseString();
            staedte[i - 1] = stadt;
        }

        int direktVerbindung;
        System.out.println("Anzahl Direktverbindungen: ");
        direktVerbindung = eingabe.leseInteger();


        String direkverbindungen[][] = new String[direktVerbindung][2];
        String start;
        for (i = 0; i < direktVerbindung; i++) {
            System.out.println("Direktverbindung: ");
            System.out.println("Start: ");
            start = eingabe.leseString();
            boolean isInArray = false;
            for (String s : staedte) {
                if (start.equals(s)) {
                    isInArray = true;
                }
            }
            if (isInArray) {
                direkverbindungen[i][0] = start;
                String ende;
                System.out.println("Ende: ");
                ende = eingabe.leseString();
                boolean isInArray2 = false;
                for (String value : staedte) {
                    if (ende.equals(value)) {
                        isInArray2 = true;
                    }
                }
                if (isInArray2) {
                    direkverbindungen[i][1] = ende;
                } else {
                    i--;
                    System.out.println("Bitte geben Sie die Städte richtig ein");
                }
            } else {
                i--;
                System.out.println("Bitte geben Sie die Städte richtig ein");
            }
        }


        while (true) {
            System.out.println("Auskunft");
            System.out.println("Start: ");
            String start1 = eingabe.leseString();
            System.out.println("Ende: ");
            String ende1 = eingabe.leseString();


            boolean isInArray2 = false;
            for (int j = 0; j < direktVerbindung; j++) {
                if (start1.equals(direkverbindungen[j][0]) && ende1.equals(direkverbindungen[j][1])) {
                    isInArray2 = true;
                }
                if (start1.equals(direkverbindungen[j][1]) && ende1.equals(direkverbindungen[j][0])) {
                    isInArray2 = true;
                }
            }
            if (isInArray2) {
                System.out.println("Zwischen " + start1 + " und " + ende1 + " ist eine Verbindung vorhanden");
            } else {
                System.out.println("Zwischen " + start1 + " und " + ende1 + " ist eine Verbindung nicht vorhanden");
            }
        }
    }
}
