public class Aufgabe5 {
    public static void main(String[] args) {
        Aufgabe5 a = new Aufgabe5();
        a.getBetrag(-3);
        a.getAnzahlZiffern(-12334344);
        a.getZiffernWert(12345, 3);
    }

    int getBetrag (int zahl){
        zahl = Math.abs(zahl);
        System.out.println(zahl);
        return zahl;
        /*if (zahl < 0){
            zahl = zahl * (-1);
            System.out.println(zahl);
            return zahl;
        }
        else {
            System.out.println(zahl);
            return zahl;
        }
         */
    }

    int getAnzahlZiffern(int zahl){
        //String i = Integer.toString(zahl);
        String i = zahl + "";
        if(zahl > 0) {
            zahl = i.length();
            System.out.println(zahl);
            return zahl;
        }
        else {
            zahl = i.length() - 1;
            System.out.println(zahl);
            return zahl;
        }
    }

    int getZiffernWert(int zahl, int stelle){
        int i = (Math.abs(zahl) / (int)Math.pow(10, stelle)) %10;
        System.out.println(i);
        return i;
    }
}
