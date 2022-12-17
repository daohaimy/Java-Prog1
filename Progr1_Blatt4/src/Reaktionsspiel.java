
public class Reaktionsspiel {
    EinUndAusgabe eingabe = new EinUndAusgabe();
    int zufall;
    String a = "a";
    String b = "b";
    String c = "c";
    String d = "d";
    String e = "e";
    String f = "f";
    String g = "g";
    String h = "h";
    String i = "i";
    String j = "j";
    String k = "k";
    String l = "l";
    String m = "m";
    String n = "n";
    String o = "o";
    String p = "p";
    String q = "q";
    String r = "r";
    String s = "s";
    String t = "t";
    String u = "u";
    String v = "v";
    String w = "w";
    String x = "x";
    String y = "y";
    String z = "z";
    String buchstabenZufall(){
        if (zufall == 1){
            return a;
        }
        if (zufall == 2){
            return b;
        }
        if (zufall == 3){
            return c;
        }
        if (zufall == 4){
            return d;
        }
        if (zufall == 5){
            return e;
        }
        if (zufall == 6){
            return f;
        }
        if (zufall == 7){
            return g;
        }
        if (zufall == 8){
            return h;
        }
        if (zufall == 9){
            return i;
        }
        if (zufall == 10){
            return j;
        }
        if (zufall == 11){
            return k;
        }
        if (zufall == 12){
            return l;
        }
        if (zufall == 13){
            return m;
        }
        if (zufall == 14){
            return n;
        }
        if (zufall == 15){
            return o;
        }
        if (zufall == 16){
            return p;
        }
        if (zufall == 17){
            return q;
        }
        if (zufall == 18){
            return r;
        }
        if (zufall == 19){
            return s;
        }
        if (zufall == 20){
            return t;
        }
        if (zufall == 21){
            return u;
        }
        if (zufall == 22){
            return v;
        }
        if (zufall == 23){
            return w;
        }
        if (zufall == 24){
            return x;
        }
        if (zufall == 25){
            return y;
        }
        if (zufall == 0){
            return z;
        }
        return buchstabenZufall();
    }

    /*
    public char getRandomLetter(){
        Random random = new Random();
        char randomizedCharacter = (char) (random.nextInt(26) + 'a');
        return randomizedCharacter;
    }
     */

    long zeitStart;
    long zeitStop;
    long zwischenZeit;
    String mensch;
    String zeichen;
    long langsam;
    long schnell;
    long mittelwert;

    void starte() {
        int rundenAnzahl = 0;
        int fehler = 0;
        int runde = getRandomNumber(5) + 5;
        langsam = 0;
        schnell = 0;

        System.out.println("Achtung: Start!");
        while(rundenAnzahl < runde) {
            rundenAnzahl++;
            wait(getRandomNumber(3) + 2);
            zufall = getRandomNumber(25);
            this.zeichen = buchstabenZufall();
            System.out.println(buchstabenZufall());


            this.zeitStart = this.getMilliSeconds();
            this.mensch = eingabe.leseString();
            this.zeitStop = this.getMilliSeconds();
            if (this.mensch.equals(this.zeichen)) {
                this.zwischenZeit = this.zeitStop - this.zeitStart;
                this.mittelwert = this.mittelwert + this.zwischenZeit;
                if (this.langsam == 0) {
                    this.langsam = this.zwischenZeit;
                } else if (this.langsam != 0 && this.langsam < this.zwischenZeit) {
                    this.langsam = this.zwischenZeit;
                }

                if (this.schnell == 0) {
                    this.schnell = this.zwischenZeit;
                } else if (this.schnell != 0 && this.schnell > this.zwischenZeit) {
                    this.schnell = this.zwischenZeit;
                }
            } else {
                fehler++;
            }
        }



        if (rundenAnzahl == runde){
            System.out.println("Geschafft: Ende!");
            System.out.println("Fehlversuche: " + fehler + " von " + runde);
            double langSam = this.langsam/1000.0 + (this.langsam%1000.0)/1000.0;
            double schNell = this.schnell/1000.0 + (this.schnell%1000.0)/1000.0;
            //double mittelWert = (langSam + schNell)/2;
            double mittelWert = (this.mittelwert / (rundenAnzahl - fehler));
            mittelWert = mittelWert/1000.0 + (mittelWert%1000.0)/1000.0;
            String langsamString = String.format("%.03f", langSam);
            String schnellString = String.format("%.03f", schNell);
            String mittelwertString = String.format("%.03f", mittelWert);

            System.out.println("Reaktionszeit-Mittelwert: " + mittelwertString +  " Sekunden");
            System.out.println("Langsamster Versuch: " + langsamString + " Sekunden");
            System.out.println("Schnellster Versuch: " + schnellString + " Sekunden");
        }
    }

    public long getMilliSeconds() {
        return new java.util.Date().getTime();
    }
    int getRandomNumber(int max) {
        return new java.util.Random().nextInt(max + 1);
    }
    void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception exc) {
        }
    }
    long getMaxLongNumber() {
        return Long.MAX_VALUE;
    }
}
