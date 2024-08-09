public class RushHour {
    EinUndAusgabe ea = new EinUndAusgabe();
    String richtung;
    String[][] autos = {{"1", "2", "2", " ", "3", " "},
                        {"1", "4", "5", " ", "3", "6"},
                        {"1", "4", "5", "*", "*", "6"},
                        {"7", "7", "7", "8", " ", "6"},
                        {" ", " ", "9", "8", "a", "a"},
                        {"b", "b", "9", "c", "c", " "}};

    public void feld(){
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[0][0] + " | " + autos[0][1] + " | " + autos[0][2] + " | " + autos[0][3] + " | " + autos[0][4] + " | " + autos[0][5] + " |");
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[1][0] + " | " + autos[1][1] + " | " + autos[1][2] + " | " + autos[1][3] + " | " + autos[1][4] + " | " + autos[1][5] + " |");
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[2][0] + " | " + autos[2][1] + " | " + autos[2][2] + " | " + autos[2][3] + " | " + autos[2][4] + " | " + autos[2][5] + " ");
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[3][0] + " | " + autos[3][1] + " | " + autos[3][2] + " | " + autos[3][3] + " | " + autos[3][4] + " | " + autos[3][5] + " |");
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[4][0] + " | " + autos[4][1] + " | " + autos[4][2] + " | " + autos[4][3] + " | " + autos[4][4] + " | " + autos[4][5] + " |");
        System.out.println("+---+---+---+---+---+---+");
        System.out.println("| " + autos[5][0] + " | " + autos[5][1] + " | " + autos[5][2] + " | " + autos[5][3] + " | " + autos[5][4] + " | " + autos[5][5] + " |");
        System.out.println("+---+---+---+---+---+---+");
    }

    public void angeben() {
        /*
        String[][] array2 = {{"1", "2", "2", " ", "3", " "},
                             {"1", "4", "5", " ", "3", "6"},
                             {"1", "4", "5", "*", "*", "6"},
                             {"7", "7", "7", "8", " ", "6"},
                             {" ", " ", "9", "8", "a", "a"},
                             {"b", "b", "9", "c", "c", " "}};
         */
        String[][] array2 = autos;

        System.out.println("Wahl eines Auto (Buchstabe angeben): ");
        String buchstabe = ea.leseString();

            for (int i = 0; i < autos.length; i++) {
                for (int j = 0; j < autos.length; j++) {
                    if (autos[i][j].equals(buchstabe)) {
                        autos[i][j] = array2[i][j];
                    }
                }
            }


        do {
            System.out.println("Richtung (l = links, r = rechts, u = hoch, d = runter, q = Autowechseln): ");
            richtung = ea.leseString();

            if(!richtung.equals("l") && !richtung.equals("r") && !richtung.equals("u") && !richtung.equals("d") && !richtung.equals("q")){
                System.out.println("Bitte geben sie richtige Richtung an!");
                System.out.println("Richtung (l = links, r = rechts, u = hoch, d = runter, q = Autowechseln): ");
                richtung = ea.leseString();
            }

            //  links
            if (richtung.equals("l")) {
                for (int i = 0; i < autos.length; i++) {
                    for (int j = 0; j < autos.length; j++) {
                        if (autos[i][j].equals(buchstabe)) {
                            try {
                                try {
                                    if (autos[i - 1][j].equals(buchstabe) || autos[i + 1][j].equals(buchstabe)) {
                                        System.out.println("Dieses Auto kann nur nach oben oder runter schieben!");
                                        angeben();
                                    }
                                }
                                catch (ArrayIndexOutOfBoundsException e){
                                    System.out.print("");
                                }
                                if (autos[i][j-1].equals(" ")) {
                                    autos = array2;
                                    autos[i][j - 1] = array2[i][j];
                                    autos[i][j] = " ";
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Dieses Auto kann nicht mehr nach links!");
                            }
                        }
                    }
                }
                feld();
            }

            //  rechts
            if (richtung.equals("r")) {
                for (int i = autos.length - 1; i >= 0; i--) {
                    for (int j = autos.length - 1; j >= 0; j--) {
                        if (autos[i][j].equals(buchstabe)) {
                            try {
                                try {
                                    if (autos[i - 1][j].equals(buchstabe) || autos[i + 1][j].equals(buchstabe)) {
                                        System.out.println("Dieses Auto kann nur nach oben oder runter schieben!");
                                        angeben();
                                    }
                                }
                                catch (ArrayIndexOutOfBoundsException e){
                                    System.out.print("");
                                }

                                if (autos[i][j + 1].equals(" ")){
                                    autos = array2;
                                    autos[i][j + 1] = array2[i][j];
                                    autos[i][j] = " ";
                                }
                            }catch (ArrayIndexOutOfBoundsException e){
                                if(buchstabe.equals("*")){
                                    richtung = "gewonnen";
                                }
                                else {
                                    System.out.println("Dieses Auto kann nicht mehr nach rechts!");
                                }
                            }
                        }
                    }
                }
                feld();
            }

            //  hoch
            if (richtung.equals("u")) {
                for (int i = 0; i < autos.length; i++) {
                    for (int j = 0; j < autos.length; j++) {
                        if (autos[i][j].equals(buchstabe)) {
                            try {
                                try {
                                    if (autos[i][j - 1].equals(buchstabe) || autos[i][j + 1].equals(buchstabe)) {
                                        System.out.println("Dieses Auto kann nur nach links oder rechts schieben!");
                                        angeben();
                                    }
                                }
                                catch (ArrayIndexOutOfBoundsException e){
                                    System.out.print("");
                                }

                                if (autos[i-1][j].equals(" ")) {
                                    autos = array2;
                                    autos[i - 1][j] = array2[i][j];
                                    autos[i][j] = " ";
                                }
                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Dieses Auto kann nicht mehr hoch schieben!");
                            }
                        }
                    }
                }
                feld();
            }

            //  runter
            if (richtung.equals("d")) {
                for (int i = autos.length - 1; i >= 0; i--) {
                    for (int j = autos.length - 1; j >= 0; j--) {
                        if (autos[i][j].equals(buchstabe)) {
                            try {
                                try {
                                    if (autos[i][j - 1].equals(buchstabe) || autos[i][j + 1].equals(buchstabe)) {
                                        System.out.println("Dieses Auto kann nur nach links oder rechts schieben!");
                                        angeben();
                                    }
                                }
                                catch (ArrayIndexOutOfBoundsException e){
                                    System.out.print("");
                                }
                                if (autos[i+1][j].equals(" ")) {
                                    autos = array2;
                                    autos[i + 1][j] = array2[i][j];
                                    autos[i][j] = " ";
                                }

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Dieses Auto kann nicht mehr runter schieben");
                            }
                        }
                    }
                }
                feld();
            }
        } while(!richtung.equals("q") && !richtung.equals("gewonnen"));

        if(richtung.equals("gewonnen")){
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[0][0] + " | " + autos[0][1] + " | " + autos[0][2] + " | " + autos[0][3] + " | " + autos[0][4] + " | " + autos[0][5] + " |");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[1][0] + " | " + autos[1][1] + " | " + autos[1][2] + " | " + autos[1][3] + " | " + autos[1][4] + " | " + autos[1][5] + " |");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[2][0] + " | " + autos[2][1] + " | " + autos[2][2] + " | " + autos[2][3] + " | " + " " + " | " + autos[2][5] + " " + "  *");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[3][0] + " | " + autos[3][1] + " | " + autos[3][2] + " | " + autos[3][3] + " | " + autos[3][4] + " | " + autos[3][5] + " |");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[4][0] + " | " + autos[4][1] + " | " + autos[4][2] + " | " + autos[4][3] + " | " + autos[4][4] + " | " + autos[4][5] + " |");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("| " + autos[5][0] + " | " + autos[5][1] + " | " + autos[5][2] + " | " + autos[5][3] + " | " + autos[5][4] + " | " + autos[5][5] + " |");
            System.out.println("+---+---+---+---+---+---+");
            System.out.println("Du hast gewonnen!");
        }
        else {
            angeben();
        }

    }
}
