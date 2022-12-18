public class SchiffeVersenken {
    EinUndAusgabe eingabe = new EinUndAusgabe();
    /*
    0 = frei,
    1 = Boot,
    2 = getroffen,
    3 = Feld geraten, aber kein Boot.
     */
    public static final int prozentualeanteil = 10;
    public static final int frei = 0;
    public static final int boot = 1;
    public static final int getroffen = 2;
    public static final int geratenFalsch = 3;

    public void spiel() {
        int breiteFeld;
        int zeile;
        int spalte;
        int zeile1;
        int spalte1;
        String f;
        int punkteErreicht1 = 0;
        int punkteErreicht2 = 0;
        int punkteGewinn;
        int punkteStand1 = 0;
        int punkteStand2 = 0;


        System.out.println("Breite des Feldes: ");
        breiteFeld = eingabe.leseInteger();
        while (breiteFeld < 0) {
            System.out.println("Bitte geben Sie eine positibe Zahl für das Feld ein!");
            breiteFeld = eingabe.leseInteger();
        }
        int[][] feld1 = new int[breiteFeld][breiteFeld];
        int[][] feld2 = new int[breiteFeld][breiteFeld];
        int[][] feld = new int[breiteFeld][breiteFeld];
        int[][] feld3 = new int[breiteFeld][breiteFeld];
        int[][] feld4 = new int[breiteFeld][breiteFeld];

        //Anfang Feld
        System.out.print("    ");
        for (int i = 0; i < breiteFeld; i++) {
            System.out.print(i + "   ");
        }
        System.out.println();
        for (int x = 0; x < breiteFeld; x++) {
            System.out.print("  ");
            for (int y = 0; y < breiteFeld; y++) {
                System.out.print("----");
            }
            System.out.print("-");
            System.out.println();
            System.out.print(x);
            for (int y = 0; y < breiteFeld; y++) {
                if (feld[x][y] == frei) {
                    f = " ";
                    System.out.print(" | " + f);
                }
            }
            System.out.println(" |");
        }
        for (int p = 0; p < breiteFeld; p++) {
            System.out.print("_____");
        }
        System.out.println();
        //Ende Feld

        // Spieler 1 Bootplatzieren
        System.out.println("Spieler 1:");
        System.out.println("Boot platzieren: ");
        for (int i = 0; i < anzahlBoote(breiteFeld); i++) {
            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

            if (bootPlatzieren(feld1, zeile, spalte)) {
                feld1[zeile][spalte] = boot;
                punkteErreicht1 = punkteErreicht1 + zeile + spalte;
                System.out.print("    ");
                for (int j = 0; j < breiteFeld; j++) {
                    System.out.print(j + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld1[x][y] == frei) {
                            f = String.valueOf(feld1[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld1[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
            } else {
                i--;
                System.out.println("Dieses Platz wurde schon platziert. Bitte in einem anderem Platz platzieren!");
            }
        }


        // Spieler 2 Bootplatzieren
        System.out.println("Spieler 2:");
        System.out.println("Boot platzieren: ");
        for (int i = 0; i < anzahlBoote(breiteFeld); i++) {
            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

            if (bootPlatzieren(feld2, zeile, spalte)) {
                feld2[zeile][spalte] = boot;
                punkteErreicht2 = punkteErreicht2 + zeile + spalte;
                System.out.print("    ");
                for (int j = 0; j < breiteFeld; j++) {
                    System.out.print(j + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld2[x][y] == frei) {
                            f = String.valueOf(feld2[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld2[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
            } else {
                i--;
                System.out.println("Dieses Platz wurde schon platziert. Bitte in einem anderem Platz platzieren!");
            }
        }


        System.out.println("Es können " + punkteErreicht1 + " Punkte bei Spieler 1 und " + punkteErreicht2 + " Punkte bei Spieler 2 erreicht werden");
        System.out.println("Wie viele Punkte bis zum Gewinn?");
        punkteGewinn = eingabe.leseInteger();


        if (punkteErreicht1 > punkteErreicht2) {
            while (punkteGewinn > punkteErreicht2 || punkteGewinn < 1) {
                System.out.println("Bitte geben Sie die gültige Punkte von 1 bis " + punkteErreicht2);
                punkteGewinn = eingabe.leseInteger();
            }
        }
        if (punkteErreicht2 > punkteErreicht1) {
            while (punkteGewinn > punkteErreicht1 || punkteGewinn < 1) {
                System.out.println("Bitte geben Sie die gültige Punkte von 1 bis " + punkteErreicht1);
                punkteGewinn = eingabe.leseInteger();
            }
        }
        if (punkteErreicht2 == punkteErreicht1) {
            while (punkteGewinn > punkteErreicht1) {
                System.out.println("Bitte geben Sie die gültige Punkte von 1 bis " + punkteErreicht1);
                punkteGewinn = eingabe.leseInteger();
            }
        }


        System.out.println("Punkte bis zum Gewinn: " + punkteGewinn);
        System.out.println("Spiel beginnt");


        //Spielbeginn
        do {
            //Anfang Feld
            System.out.print("    ");
            for (int i = 0; i < breiteFeld; i++) {
                System.out.print(i + "   ");
            }
            System.out.println();
            for (int x = 0; x < breiteFeld; x++) {
                System.out.print("  ");
                for (int y = 0; y < breiteFeld; y++) {
                    System.out.print("----");
                }
                System.out.print("-");
                System.out.println();
                System.out.print(x);
                for (int y = 0; y < breiteFeld; y++) {
                    if (feld3[x][y] == frei) {
                        f = " ";
                        System.out.print(" | " + f);
                    }
                }
                System.out.println(" |");
            }
            for (int p = 0; p < breiteFeld; p++) {
                System.out.print("_____");
            }
            System.out.println();
            //Ende Feld


            System.out.println("Spieler 1 ist dran: ");

            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

            while (1 == feld2[zeile][spalte] && punkteStand1 < punkteGewinn) {
                //SPIELER 1
                feld3[zeile][spalte] = 2;
                feld2[zeile][spalte] = 2;
                //Anfang Feld
                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld3[x][y] == 0) {
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld3[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();

                punkteStand1 = punkteStand1 + zeile + spalte;
                System.out.println("Getroffen! Du darfst nochmal.");
                System.out.println("Zeile: ");
                zeile1 = eingabe.leseInteger();
                while (zeile1 < 0 || zeile1 > breiteFeld - 1) {
                    System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                    zeile1 = eingabe.leseInteger();
                }
                System.out.println("Spalte: ");
                spalte1 = eingabe.leseInteger();
                while (spalte1 < 0 || spalte1 > breiteFeld - 1) {
                    System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                    spalte1 = eingabe.leseInteger();
                }

                while(feld2[zeile1][spalte1] == 3){
                    System.out.println("Da hast bereits das Feld verkackt!, wähl anderes Feld");
                    while (zeile1 < 0 || zeile1 > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        zeile1 = eingabe.leseInteger();
                    }
                    System.out.println("Spalte: ");
                    spalte1 = eingabe.leseInteger();
                    while (spalte1 < 0 || spalte1 > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        spalte1 = eingabe.leseInteger();
                    }
                }

                if (feld2[zeile1][spalte1] == 0) {
                    feld3[zeile1][spalte1] = 3;
                    feld2[zeile1][spalte1] = 3;
                    System.out.print("    ");
                    for (int i = 0; i < breiteFeld; i++) {
                        System.out.print(i + "   ");
                    }
                    System.out.println();
                    for (int x = 0; x < breiteFeld; x++) {
                        System.out.print("  ");
                        for (int y = 0; y < breiteFeld; y++) {
                            System.out.print("----");
                        }
                        System.out.print("-");
                        System.out.println();
                        System.out.print(x);
                        for (int y = 0; y < breiteFeld; y++) {
                            if (feld3[x][y] == frei) {
                                f = " ";
                                System.out.print(" | " + f);
                            } else {
                                System.out.print(" | " + feld3[zeile1][spalte1]);
                            }
                        }
                        System.out.println(" |");
                    }
                    for (int p = 0; p < breiteFeld; p++) {
                        System.out.print("_____");
                    }
                    System.out.println();
                    if(punkteStand1 < punkteGewinn) {
                        System.out.println("verfehlt!");
                        System.out.println("Spieler 2 ist dran");
                    }
                    System.out.print("    ");
                    for (int i = 0; i < breiteFeld; i++) {
                        System.out.print(i + "   ");
                    }
                    System.out.println();
                    for (int x = 0; x < breiteFeld; x++) {
                        System.out.print("  ");
                        for (int y = 0; y < breiteFeld; y++) {
                            System.out.print("----");
                        }
                        System.out.print("-");
                        System.out.println();
                        System.out.print(x);
                        for (int y = 0; y < breiteFeld; y++) {
                            if (feld4[x][y] == frei) {
                                f = " ";
                                System.out.print(" | " + f);
                            }
                        }
                        System.out.println(" |");
                    }
                    for (int p = 0; p < breiteFeld; p++) {
                        System.out.print("_____");
                    }
                    }

                }
            if (feld2[zeile][spalte] == 0) {
                feld3[zeile][spalte] = 3;
                feld2[zeile][spalte] = 3;
                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld3[x][y] == frei) {
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld3[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                if(punkteStand1 < punkteGewinn) {
                    System.out.println("verfehlt!");
                    System.out.println("Spieler 2 ist dran");
                }


                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld4[x][y] == frei) {
                            f = " ";
                            System.out.print(" | " + f);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }

            }


            // SPIELER 2

            System.out.println();
            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

                    while (1 == feld1[zeile][spalte] && punkteStand2 < punkteGewinn) {
                        feld4[zeile][spalte] = 2;
                        feld1[zeile][spalte] = 2;
                        //Anfang Feld
                        System.out.print("    ");
                        for (int i = 0; i < breiteFeld; i++) {
                            System.out.print(i + "   ");
                        }
                        System.out.println();
                        for (int x = 0; x < breiteFeld; x++) {
                            System.out.print("  ");
                            for (int y = 0; y < breiteFeld; y++) {
                                System.out.print("----");
                            }
                            System.out.print("-");
                            System.out.println();
                            System.out.print(x);
                            for (int y = 0; y < breiteFeld; y++) {
                                if (feld4[x][y] == frei) {
                                    f = " ";
                                    System.out.print(" | " + f);
                                } else {
                                    System.out.print(" | " + feld4[zeile][spalte]);
                                }
                            }
                            System.out.println(" |");
                        }
                        for (int p = 0; p < breiteFeld; p++) {
                            System.out.print("_____");
                        }
                        System.out.println();

                        punkteStand2 = punkteStand2 + zeile + spalte;
                        System.out.println("Getroffen! Du darfst nochmal.");
                        System.out.println("Zeile: ");
                        zeile1 = eingabe.leseInteger();
                        while (zeile1 < 0 || zeile1 > breiteFeld - 1) {
                            System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                            zeile1 = eingabe.leseInteger();
                        }
                        System.out.println("Spalte: ");
                        spalte1 = eingabe.leseInteger();
                        while (spalte1 < 0 || spalte1 > breiteFeld - 1) {
                            System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                            spalte1 = eingabe.leseInteger();
                        }


                        if (feld1[zeile1][spalte1] == 0) {
                            feld4[zeile1][spalte1] = 3;
                            feld1[zeile1][spalte1] = 3;
                            System.out.print("    ");
                            for (int i = 0; i < breiteFeld; i++) {
                                System.out.print(i + "   ");
                            }
                            System.out.println();
                            for (int x = 0; x < breiteFeld; x++) {
                                System.out.print("  ");
                                for (int y = 0; y < breiteFeld; y++) {
                                    System.out.print("----");
                                }
                                System.out.print("-");
                                System.out.println();
                                System.out.print(x);
                                for (int y = 0; y < breiteFeld; y++) {
                                    if (feld4[x][y] == frei) {
                                        f = " ";
                                        System.out.print(" | " + f);
                                    } else {
                                        System.out.print(" | " + feld4[zeile1][spalte1]);
                                    }
                                }
                                System.out.println(" |");
                            }
                            for (int p = 0; p < breiteFeld; p++) {
                                System.out.print("_____");
                            }
                            System.out.println();
                            if(punkteStand2 < punkteGewinn) {
                                System.out.println("verfehlt!");
                                System.out.println("Spieler 1 ist dran");
                            }

                            //Anfang Feld
                            System.out.print("    ");
                            for (int i = 0; i < breiteFeld; i++) {
                                System.out.print(i + "   ");
                            }
                            System.out.println();
                            for (int x = 0; x < breiteFeld; x++) {
                                System.out.print("  ");
                                for (int y = 0; y < breiteFeld; y++) {
                                    System.out.print("----");
                                }
                                System.out.print("-");
                                System.out.println();
                                System.out.print(x);
                                for (int y = 0; y < breiteFeld; y++) {
                                    if (feld3[x][y] == frei) {
                                        f = " ";
                                        System.out.print(" | " + f);
                                    }
                                }
                                System.out.println(" |");
                            }
                            for (int p = 0; p < breiteFeld; p++) {
                                System.out.print("_____");
                            }
                            System.out.println();
                            //Ende Feld
                        }
                    }

            if (feld1[zeile][spalte] == 0) {
                feld4[zeile][spalte] = 3;
                feld1[zeile][spalte] = 3;
                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld4[x][y] == frei) {
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld4[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                if(punkteStand2 < punkteGewinn) {
                    System.out.println("verfehlt!");
                    System.out.println("Spieler 1 ist dran");
                }
            }
                //Ende Feld
        } while (punkteStand1 < punkteGewinn && punkteStand2 < punkteGewinn) ;

            System.out.println("Spieler 1 hat " + punkteStand1 + " Punkte und Spieler 2 hat " + punkteStand2 + " Punkte.");
            if (punkteStand1 > punkteStand2) {
                System.out.println("Spieler 1 hat gewonnen!");
            }
            if (punkteStand2 > punkteStand1) {
                System.out.println("Spieler 2 hat gewonnen!");
            }
            if (punkteStand1 == punkteStand2) {
                System.out.println("unentschieden!");
            }


        /*
        do{
            System.out.println("Spieler 1 ist dran: ");

            //Anfang Feld
            System.out.print("    ");
            for (int i = 0; i < breiteFeld; i++) {
                System.out.print(i + "   ");
            }
            System.out.println();
            for (int x = 0; x < breiteFeld; x++) {
                System.out.print("  ");
                for (int y = 0; y < breiteFeld; y++) {
                    System.out.print("----");
                }
                System.out.print("-");
                System.out.println();
                System.out.print(x);
                for (int y = 0; y < breiteFeld; y++) {
                    if (feld2[x][y] == frei && feld2[x][y] == boot) {
                        f = " ";
                        System.out.print(" | " + f);
                    }
                }
                System.out.println(" |");
            }
            for (int p = 0; p < breiteFeld; p++) {
                System.out.print("_____");
            }
            System.out.println();



            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

            while (raten(feld2, zeile, spalte)){
                feld4[zeile][spalte] = getroffen;
                punkteStand1 = punkteStand1 + zeile + spalte;
                //Anfang Spieler 1
                System.out.print("    ");
                System.out.println("Getroffen! Du darfst noch weiter raten!");
                    System.out.println("Zeile: ");
                    zeile = eingabe.leseInteger();
                    while (zeile < 0 || zeile > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        zeile = eingabe.leseInteger();
                    }
                    System.out.println("Spalte: ");
                    spalte = eingabe.leseInteger();
                    while (spalte < 0 || spalte > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        spalte = eingabe.leseInteger();
                    }

                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld2[x][y] == frei && feld2[x][y] == boot) {
                            f = String.valueOf(feld2[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                        System.out.print(" | " + feld4[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                //Ende Spieler 1
            }
            if(!raten(feld2, zeile, spalte)){
                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld4[x][y] == frei && feld4[x][y] == boot) {
                            f = String.valueOf(feld4[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        }
                        else {
                            System.out.print(" | " + geratenFalsch);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                System.out.println("Spieler 2 ist dran: ");
            }

            //Spieler 2
            //Anfang Feld
            System.out.print("    ");
            for (int i = 0; i < breiteFeld; i++) {
                System.out.print(i + "   ");
            }
            System.out.println();
            for (int x = 0; x < breiteFeld; x++) {
                System.out.print("  ");
                for (int y = 0; y < breiteFeld; y++) {
                    System.out.print("----");
                }
                System.out.print("-");
                System.out.println();
                System.out.print(x);
                for (int y = 0; y < breiteFeld; y++) {
                    if (feld1[x][y] == frei && feld1[x][y] == boot) {
                        f = String.valueOf(feld1[x][y]);
                        f = " ";
                        System.out.print(" | " + f);
                    }
                }
                System.out.println(" |");
            }
            for (int p = 0; p < breiteFeld; p++) {
                System.out.print("_____");
            }
            System.out.println();
            //Ende Feld


            System.out.println("Zeile: ");
            zeile = eingabe.leseInteger();
            while (zeile < 0 || zeile > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                zeile = eingabe.leseInteger();
            }
            System.out.println("Spalte: ");
            spalte = eingabe.leseInteger();
            while (spalte < 0 || spalte > breiteFeld - 1) {
                System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                spalte = eingabe.leseInteger();
            }

            while (raten(feld1, zeile, spalte)){
                feld3[zeile][spalte] = getroffen;
                punkteStand2 = punkteStand2 + zeile + spalte;
                //Anfang Spieler 2
                System.out.print("    ");
                    System.out.println("Getroffen! Du darfst noch weiter raten!");
                    System.out.println("Zeile: ");
                    zeile = eingabe.leseInteger();
                    while (zeile < 0 || zeile > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Zeile (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        zeile = eingabe.leseInteger();
                    }
                    System.out.println("Spalte: ");
                    spalte = eingabe.leseInteger();
                    while (spalte < 0 || spalte > breiteFeld - 1) {
                        System.out.println("Bitte geben Sie die richtige Spalte (0 bis " + (breiteFeld - 1) + ") des Feldes ein!");
                        spalte = eingabe.leseInteger();
                    }

                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld1[x][y] == frei && feld1[x][y] == boot) {
                            f = String.valueOf(feld1[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        } else {
                            System.out.print(" | " + feld3[zeile][spalte]);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                //Ende Feld 2
            }


            if(!raten(feld2, zeile, spalte)){
                System.out.print("    ");
                for (int i = 0; i < breiteFeld; i++) {
                    System.out.print(i + "   ");
                }
                System.out.println();
                for (int x = 0; x < breiteFeld; x++) {
                    System.out.print("  ");
                    for (int y = 0; y < breiteFeld; y++) {
                        System.out.print("----");
                    }
                    System.out.print("-");
                    System.out.println();
                    System.out.print(x);
                    for (int y = 0; y < breiteFeld; y++) {
                        if (feld1[x][y] == frei && feld1[x][y] == boot) {
                            f = String.valueOf(feld1[x][y]);
                            f = " ";
                            System.out.print(" | " + f);
                        }
                        else {
                            System.out.print(" | " + geratenFalsch);
                        }
                    }
                    System.out.println(" |");
                }
                for (int p = 0; p < breiteFeld; p++) {
                    System.out.print("_____");
                }
                System.out.println();
                System.out.println("Spieler 1 ist dran: ");
            }


        }while(punkteStand1 < punkteGewinn && punkteStand2 < punkteGewinn);

        if(punkteStand1 > punkteGewinn){
            System.out.println("Spieler 1 hat gewonnen");
        }
        if(punkteStand2 > punkteGewinn){
            System.out.println("Spieler 2 hat gewonnen");
        }

 */

        }


    public static boolean bootPlatzieren(int[][] spielfeld, int x, int y){
        if (spielfeld[x][y] != boot){
            return true;
        }
        else {
            return false;
        }
    }

    public static int anzahlBoote(int breite) {
        return breite * breite * prozentualeanteil/100;
    }

    public static boolean raten(int[][] feld, int x, int y) {
        if (feld[x][y] == geratenFalsch) {
            System.out.println("Da ist kein Boot!");
            return false;
        } else if (feld[x][y] != boot) {
            feld[x][y] = geratenFalsch;
            return false;
        }
        feld[x][y] = getroffen;
        return true;
    }
}
