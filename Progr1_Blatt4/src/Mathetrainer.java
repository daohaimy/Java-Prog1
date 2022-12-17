import java.util.Random;
public class Mathetrainer {
    EinUndAusgabe eingabe = new EinUndAusgabe();
    Random random = new Random();
    void starte() {
        System.out.println("Start des Mathetrainers");
        int ergebnis;
        int korrekt = 0;

            while (korrekt < 10){
                boolean operator = generiereOperator();
            if (operator == true) {
                int x = generiereZahl();
                int y = random.nextInt(9);
                System.out.println(x + " * " + y + " = ");
                ergebnis = x * y;
                int ergebnisVonLeser = eingabe.leseInteger();
                if (ergebnis == ergebnisVonLeser) {
                    korrekt++;
                    System.out.println("Richtig!");
                    System.out.println("Korrekte Antwort: " + korrekt);
                } else {
                    System.out.println("Leider falsch! Korrektes Ergebnis ist " + ergebnis);
                    System.out.println("Korrekte Antwort: " + korrekt);
                }
            }
            else{
                int x = generiereZahl();
                int y = random.nextInt(8) + 1;
                System.out.println(x + " / " + y + " = ");
                ergebnis = x / y;
                int ergebnisVonLeser = eingabe.leseInteger();
                if (ergebnis == ergebnisVonLeser) {
                    korrekt++;
                    System.out.println("Richtig!");
                    System.out.println("Korrekte Antwort: " + korrekt);
                } else {
                    System.out.println("Leider falsch! Korrektes Ergebnis ist " + ergebnis);
                    System.out.println("Korrekte Antwort: " + korrekt);
                }
            }

        }
            if (korrekt == 10) {
                System.out.println("Ende des Mathetrainers");
            }
    }

    int generiereZahl(){
        return random.nextInt(9);
    }

    boolean generiereOperator(){
        return random.nextBoolean();
    }

}
/*
    Mathetrainer probe = new Mathetrainer();
    probe.starte();
 */
