public class Aufgabe1 {
    EinUndAusgabe eingabe = new EinUndAusgabe();

    void starte() {
        int zahl = eingabe.leseInteger();
        switch (zahl){
            case 5: case 6:
                System.out.println("ja");
                break;
            case 4:
                System.out.println("weiss nicht");
                break;
            case -1: case 0: case 1:
                System.out.println("nein");
                break;
            default:
                System.out.println("vielleicht");
                break;
        }
        /*
        if (zahl > 3 && zahl < 7) {
            if (zahl > 4 && zahl < 10) {
                System.out.println("ja");
            } else {
                System.out.println("weiss nicht");
            }
        } else if (zahl >= -1 && zahl <= 1) {
            System.out.println("nein");
        } else {
            System.out.println("vielleicht");
        }
         */
    }

}
