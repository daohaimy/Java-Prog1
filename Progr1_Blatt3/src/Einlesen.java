import java.time.LocalDate;

public class Einlesen {
    void starte() {
        LocalDate localDate = LocalDate.ofEpochDay(0);
        EinUndAusgabe eingabe = new EinUndAusgabe();
        System.out.println("Vorname: ");
        String vorname = eingabe.leseString();
        System.out.println("Nachname : ");
        String nachname = eingabe.leseString();
        System.out.println("Hallo " + vorname + " " + nachname);

        System.out.println("Geburtsdatum Tag : ");
        tag = eingabe.leseInteger();
        if (tag < 0 || tag > 31) {
            System.out.println("Der Tag existiert nicht.");
        } else {
            System.out.println("Geburtsdatum Monat : ");
            monat = eingabe.leseInteger();
            if ((monat < 0 || monat > 12) || (tag >= 31 && (monat == 4 || monat == 6 || monat == 9 || monat == 11)) || (tag >= 30 && monat == 2)) {
                System.out.println("Der Datum existiert nicht.");
            } else {
                System.out.println("Geburtsdatum Jahr : ");
                jahr = eingabe.leseInteger();
                schaltjahr();

                if(!schaltjahr() && tag >= 29 && monat == 2) {
                    System.out.println("Ihr Geburtsdatum existiert nicht");
                } else {
                        System.out.println("Ihr Geburtsdatum ist: " + tag + "." + monat + "." + jahr);
                }

                    LocalDate heute = LocalDate.now();
                    LocalDate geburtstag = LocalDate.of(jahr, monat, tag);
                    long tageAlt = heute.toEpochDay() - geburtstag.toEpochDay();
                    System.out.println("Sie sind " + tageAlt + " Tage alt");
                }
            }
        }
    static int jahr;
    int monat;
    int tag;
        public static boolean schaltjahr() {
            if ((jahr % 4 == 0) && (jahr % 100 != 0)) {
                return true;
            } else if ((jahr % 4 == 0) && (jahr % 100 != 0) && (jahr % 400 == 0)) {
                return true;
            } else {
                return false;
            }
        }
    }


