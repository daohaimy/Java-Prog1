import java.util.Arrays;
public class SliderSpiel {
    EinUndAusgabe eingabe = new EinUndAusgabe();
    String [][]spiel = {
            /*
            {" ", " ", " ", " ", " ", " "},
            {" ", " 1", " 2", " 3", " 4", " "},
            {" ", " 5", " 6", " 7", " 8", " "},
            {" ", " 9", "10", "11", "12", " "},
            {" ", "13", "14", "  ", "15", " "},
            {" ", " ", " ", " ", " ", " "}

             */

                      {" ", " ", " ", " ", " ", " "},
                      {" ", "11", "12", "13", "14", " "},
                      {" ", " 1", " 2", " 3", " 4", " "},
                      {" ", " 8", " 7", " 6", " 5", " "},
                      {" ", "  ", " 9", "10", "15", " "},
                      {" ", " ", " ", " ", " ", " "}

                    };
    String [][]loesung = {
            {" ", " ", " ", " ", " ", " "},
            {" ", " 1", " 2", " 3", " 4", " "},
            {" ", " 5", " 6", " 7", " 8", " "},
            {" ", " 9", "10", "11", "12", " "},
            {" ", "13", "14", "15", "  ", " "},
            {" ", " ", " ", " ", " ", " "}
    };
    public void slider() {
        while (!isGleich()){
            System.out.println("____________________________________");
            System.out.println("+--+--+--+--+");
            System.out.println("|" + spiel[1][1] + "|" + spiel[1][2] + "|" + spiel[1][3] + "|" + spiel[1][4] + "|");
            System.out.println("+--+--+--+--+");
            System.out.println("|" + spiel[2][1] + "|" + spiel[2][2] + "|" + spiel[2][3] + "|" + spiel[2][4] + "|");
            System.out.println("+--+--+--+--+");
            System.out.println("|" + spiel[3][1] + "|" + spiel[3][2] + "|" + spiel[3][3] + "|" + spiel[3][4] + "|");
            System.out.println("+--+--+--+--+");
            System.out.println("|" + spiel[4][1] + "|" + spiel[4][2] + "|" + spiel[4][3] + "|" + spiel[4][4] + "|");
            System.out.println("+--+--+--+--+");

            System.out.println("Zeile: ");
            int zeile = eingabe.leseInteger();
            while (zeile <= 0 || zeile >= 5) {
                System.out.println("Bitte die Zeile nur von 1 bis 4 eingeben!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            int spalte = eingabe.leseInteger();
            while (spalte <= 0 || spalte >= 5) {
                System.out.println("Bitte die Spalte nur von 1 bis 4 eingeben!");
                spalte = eingabe.leseInteger();
            }
            String zahl = spiel[zeile][spalte];

            //Lücke nach links schieben
            if ((spiel[zeile][spalte + 1]).equals("  ")) {
                if (zahl.contains(spiel[zeile][spalte])) {
                    spiel[zeile][spalte + 1] = spiel[zeile][spalte];
                    spiel[zeile][spalte] = "  ";
                }
            }
            //Lücke nach rechts schieben
            else if ((spiel[zeile][spalte - 1]).equals("  ")) {
                if (zahl.contains(spiel[zeile][spalte])) {
                    spiel[zeile][spalte - 1] = spiel[zeile][spalte];
                    spiel[zeile][spalte] = "  ";
                }
            }
            //Lücke nach oben schieben
            else if ((spiel[zeile + 1][spalte]).equals("  ")) {
                if (zahl.contains(spiel[zeile][spalte])) {
                    spiel[zeile + 1][spalte] = spiel[zeile][spalte];
                    spiel[zeile][spalte] = "  ";
                }
            }
            //Lücke nach unten schieben
            else if ((spiel[zeile - 1][spalte]).equals("  ")) {
                if (zahl.contains(spiel[zeile][spalte])) {
                    spiel[zeile - 1][spalte] = spiel[zeile][spalte];
                    spiel[zeile][spalte] = "  ";
                }
            } else {
                System.out.println("Bitte richtige Zeile und Spalte eingeben");
            }
        }

        System.out.println("____________________________________");
        System.out.println("+--+--+--+--+");
        System.out.println("|" + spiel[1][1] + "|" + spiel[1][2] + "|" + spiel[1][3] + "|" + spiel[1][4] + "|");
        System.out.println("+--+--+--+--+");
        System.out.println("|" + spiel[2][1] + "|" + spiel[2][2] + "|" + spiel[2][3] + "|" + spiel[2][4] + "|");
        System.out.println("+--+--+--+--+");
        System.out.println("|" + spiel[3][1] + "|" + spiel[3][2] + "|" + spiel[3][3] + "|" + spiel[3][4] + "|");
        System.out.println("+--+--+--+--+");
        System.out.println("|" + spiel[4][1] + "|" + spiel[4][2] + "|" + spiel[4][3] + "|" + spiel[4][4] + "|");
        System.out.println("+--+--+--+--+");
        System.out.println("Du hast gewonnen!");

    }

    public boolean isGleich() {
        for(int i = 0; i < spiel.length-1 ; i++){
            for(int j = 0; j <= spiel.length-1 ; j++) {
                if(!spiel[i][j].equals(loesung[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

}
