abstract class Frage {
    String text; // Fragetext
    int punkte; // zu erreichende Punktzahl
    Frage(String text, int punkte) {
        this.text = text;
        this.punkte = punkte;
    }
    // Frage auf den Bildschirm ausgeben
    void frageStellen() {
        IO.println(this.text);
    }
    // Frage beantworten durch Prüfling, Antwort auswerten
// und Punkte vergeben
    abstract void frageBeantworten(Pruefling person);
    int getPunkte() {
        return this.punkte;
    }
}


// Klasse, die Wahr/Falsch-Fragen realisiert
class WahrFalschFrage extends Frage {
    boolean richtig; // richtig oder falsch
    WahrFalschFrage(String text, int punkte, boolean richtig) {
        super(text, punkte);
        this.richtig = richtig;
    }
    // Frage beantworten durch Prüfling, Antwort auswerten
// und Punkte vergeben
    void frageBeantworten(Pruefling person) {
        boolean ant = IO.readChar("Wahr o. Falsch (w/f)?") == 'w';
        if (ant == this.richtig) {
            IO.println("Richt. Antw.: " + punkte + " Punkte");
            person.neuePunkte(this.punkte);
        } else {
            IO.println("Falsche Antwort: 0 Punkte");
        }
    }
}
// Klasse, die Multiple-Choice-Fragen realisiert
class MCFrage extends Frage {
    String[] antworten; // moegliche Antworten
    int richtigIndex; // Index der richtigen Antwort
    MCFrage(String text, int punkte, String[] antworten, int richtigIndex) {
        super(text, punkte);
        this.antworten = antworten;
        this.richtigIndex = richtigIndex;
    }
    // Frage auf den Bildschirm ausgeben
    void frageStellen() {
        super.frageStellen();
        for (int f = 0; f < this.antworten.length; f++) {
            IO.println("(" + f + "): " + this.antworten[f]);
        }
    }
    // Frage beantworten durch Prüfling, Antwort auswerten und Punkte vergeben
    void frageBeantworten(Pruefling person) {
        int antwort = IO.readInt("Auswahl: ");
        if (antwort == this.richtigIndex) {
            IO.println("Richtige Antwort: " + this.punkte + " Punkte");
                    person.neuePunkte(this.punkte);
        } else {
            IO.println("Falsche Antwort: 0 Punkte!");
            IO.println("Richtig Antwort ist " + this.richtigIndex);
        }
    }
}

class MehrfachauswahlFrage extends Frage {
    int[] auswahlen;
    int[] richtigIndex;
    MehrfachauswahlFrage(String text, int punkte, int[] auswahlen, int[] richtigIndex) {
        super(text, punkte);
        this.auswahlen = auswahlen;
        this.richtigIndex = richtigIndex;
    }
    void frageStellen() {
        super.frageStellen();
        for (int f = 0; f < this.auswahlen.length; f++) {
            IO.println("(" + f + "): " + this.auswahlen[f]);
        }
    }
    void frageBeantworten(Pruefling person) {
        System.out.println("Wenn Sie aufhören möchten auszuwählen, geben (-1) ein");
        int antwort = IO.readInt("Auswahl: ");
        while(antwort != -1) {
            try {
                if (antwort == this.richtigIndex[antwort]) {
                    IO.println("Richtige Antwort: " + this.punkte + " Punkte");
                    person.neuePunkte(this.punkte);
                } else {
                    IO.println("Falsche Antwort: 0 Punkte!");
                }
            }catch (ArrayIndexOutOfBoundsException e){
                IO.println("Richtige Antwort: " + this.punkte + " Punkte");
                person.neuePunkte(this.punkte);
            }
            antwort = IO.readInt("Auswahl: ");
        }
    }
}

class Lueckenfrage extends Frage {
    String richtigString;
    Lueckenfrage(String text, int punkte, String richtigString) {
        super(text, punkte);
        this.richtigString = richtigString;
    }
    void frageBeantworten(Pruefling person) {
        String antwort = IO.readString("Füllen Sie die Lücke auf: ");
        if (antwort.equals(this.richtigString)) {
            IO.println("Richtige Antwort: " + punkte + " Punkte");
            person.neuePunkte(this.punkte);
        } else {
            IO.println("Falsche Antwort: 0 Punkte");
            IO.println("Die richtige Antwort ist: " + this.richtigString);
        }
    }
}

class Zahlenfolgenerweiterungen extends Frage{
    int richtigeZahl;
    int[] zahl;
    Zahlenfolgenerweiterungen(String text, int punkte, int[] zahl, int richtigeZahl){
        super(text, punkte);
        this.zahl = zahl;
        this.richtigeZahl = richtigeZahl;
    }
    void frageBeantworten(Pruefling person) {
        IO.println("Indentifizieren Sie die Zahlenfolge und geben Sie die nächste Zahl der Folge ein! ");
        for(int i = 0; i < zahl.length; i++){
            IO.print((i+1) + " ");
        }
        int antwort = IO.readInt();
        if (antwort == richtigeZahl) {
            IO.println("Richtige Antwort: " + punkte + " Punkte");
            person.neuePunkte(this.punkte);
        } else {
            IO.println("Falsche Antwort: 0 Punkte");
            IO.println("Die richtige Antwort ist: " + this.richtigeZahl);
        }
    }
}

class Ordnungsfrage extends Frage{
    int[] antworten;
    Ordnungsfrage(String text, int punkte, int[] antworten) {
        super(text, punkte);
        this.antworten = antworten;
    }
    void frageBeantworten(Pruefling person) {
        for(int i = 0; i < antworten.length; i++) {
            int aw = IO.readInt((i+1) + ". : ");
            antworten[i] = aw;
            if (aw == antworten[aw]) {
                IO.println("Richtige Antwort: " + punkte + " Punkte");
                person.neuePunkte(this.punkte);
            }
            else {
                IO.println("Falsche Reihenfolge: 0 Punkte");
            }
        }
    }
}

class Quiz {
    Frage[] fragen; // Menge an Fragen
    String titel; // Titel des Quizes
    int aktuellerIndex; // aktuelle Anzahl an Fragen-1
    int naechsterIndex; // Schleifenvariable
    // Konstruktor
    Quiz(String titel, int maxFragen) {
        this.titel = titel;
        this.aktuellerIndex = -1;
        this.fragen = new Frage[maxFragen];
        for (int i = 0; i < this.fragen.length; i++)
            this.fragen[i] = null;
        this.naechsterIndex = -1;
    }
    String getTitel() {
        return this.titel;
    }
    // Frage hinzufuegen
    void neueFrage(Frage f) {
        if (this.aktuellerIndex < this.fragen.length - 1)
            this.fragen[++this.aktuellerIndex] = f;
    }
    // liefert zyklisch die naechste Frage oder null,
// falls keine (mehr)vorhanden ist
    Frage liefereNaechsteFrage() {
        if (this.fragen.length == 0)
            return null;
        Frage f = null;
        if (this.naechsterIndex < this.aktuellerIndex)
            f = this.fragen[++this.naechsterIndex];
        else
            this.naechsterIndex = -1;
        return f;
    }
}
class Pruefling {
    String name; // Name der Person
    int punkte; // bisher erzielte Punkte
    Pruefling(String name) {
        this.name = name;
        this.punkte = 0;
    }
    String getName() {
        return this.name;
    }
    int getPunkte() {
        return this.punkte;
    }
    void neuePunkte(int anzahl) {
        this.punkte += anzahl;
    }
}
class Pruefung {
    // Hauptprogramm
    public static void main(String[] args) {
        Pruefung klausur = new Pruefung();
        klausur.vorbereiten();
        klausur.durchfuehren();
        klausur.ergebnisseBekanntgeben();
    }
    Quiz pruefung;
    Pruefling[] studenten;
    Pruefung() {
        this.pruefung = null;
        this.studenten = null;
    }
    void vorbereiten() {
        IO.println("Fragen eingeben");
        IO.println("----------------");
        String titel = IO.readString("Titel des Quizes: ");
        int anzahl = IO.readInt("Anzahl Fragen: ");
        this.pruefung = new Quiz(titel, anzahl);
        // Fragen eingeben
        for (int i = 0; i < anzahl; i++) {
            Frage f = this.frageErzeugen(i + 1);
            this.pruefung.neueFrage(f);
        }
    }
    public Frage frageErzeugen(int nummer) {
        // spaeter Factory-Pattern
        int typ = IO.readInt("Fragetyp: Wahr/Falsch (1), Multiple Choice (2), Mehrfachauswahl (3), Lückenfrage (4), Zahlenfolgenerweiterung (5), Ordnungsfrage (6)? ");
        switch (typ) {
            case 1:
                return erzeugeWahrFalschFrage(nummer);
            case 2:
                return erzeugeMCFrage(nummer);
            case 3:
                return erzeugeMehrfachauswahl(nummer);
            case 4:
                return erzeugeLueckenfrage(nummer);
            case 5:
                return erzeugeZahlenfolgenerweiterungen(nummer);
            default:
                return erzeugeOrdnungsfrage(nummer);
        }
    }
    private Frage erzeugeWahrFalschFrage(int nummer) {
        String text = IO.readString("Frage " + (nummer) + ": ");
        boolean wahr = IO.readChar("Wahr/falsch(w/f)?") == 'w';
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new WahrFalschFrage(text, punkte, wahr);
    }
    private Frage erzeugeMCFrage(int nummer) {
        String text = IO.readString("Frage " + (nummer) + ": ");
        int anzahl = IO.readInt("Anzahl an Antworten: ");
        String[] antworten = new String[anzahl];
        for (int i = 0; i < anzahl; i++) {
            antworten[i] = IO.readString("Antwort " + i + ": ");
        }
        int richtigIndex = IO.readInt("Index der richtigen Antwort: ");
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new MCFrage(text, punkte, antworten, richtigIndex);
    }

    private Frage erzeugeMehrfachauswahl(int nummer){
        String text = IO.readString("Frage " + (nummer) + ": ");
        int anzahl = IO.readInt("Anzahl an Antworten: ");
        int[] antworten = new int[anzahl];
        for (int i = 0; i < anzahl; i++) {
        antworten[i] = IO.readInt("Antwort " + i + ": ");
        }
        int richtig = IO.readInt("Anzahl der richtigen Antwort: ");
        int[] richtigIndex = new int[richtig];
        for (int j = 0; j < richtig; j ++) {
            richtigIndex[j] = IO.readInt("richtige IndexAntwort " + j + ": ");
        }
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new MehrfachauswahlFrage(text, punkte, antworten, richtigIndex);
    }

    private Frage erzeugeLueckenfrage (int nummer){
        String text = IO.readString("Frage " + (nummer) + ": ");
        String richtigString = IO.readString("Antwort für die Lücke: ");
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new Lueckenfrage(text, punkte, richtigString);
    }

    private Frage erzeugeZahlenfolgenerweiterungen (int nummer){
        String text = IO.readString("Frage " + (nummer) + ": " + "(Zahlenfolgen ergänzen)");
        int zahlen = IO.readInt("Anzahl an vorgegebenen Zahlen: ");
        int[] zahl = new int[zahlen];
        for(int i = 0; i < zahlen; i++){
            IO.println("Zahl " + i + ": " + (i+1));
        }
        int richtigeZahl = IO.readInt("Korrekte Folgezahl: ");
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new Zahlenfolgenerweiterungen(text, punkte, zahl, richtigeZahl);
    }

    private Frage erzeugeOrdnungsfrage(int nummer) {
        String text = IO.readString("Frage " + (nummer) + ": ");
        int anzahl = IO.readInt("Anzahl an Antworten: ");
        for (int i = 0; i < anzahl; i++) {
            String antwort = IO.readString("Antwort " + i + ": ");
        }
        int index[] = new int[anzahl];
        for(int i = 0; i < anzahl; i++){
            int eingeben = IO.readInt((i+1) + ". Index: ");
            index[i] = eingeben;
        }
        int punkte = IO.readInt("Erreichbare Punkte: ");
        return new Ordnungsfrage(text, punkte, index);
    }

    void durchfuehren() {
        IO.println("Pruefung");
        IO.println("--------");
        int anzahl = IO.readInt("Anzahl Prueflinge: ");
        this.studenten = new Pruefling[anzahl];
        // alle Prueflinge abfragen
        for (int i = 0; i < anzahl; i++) {
            IO.println("Pruefling " + (i + 1) + " ist an der Reihe");
            this.studenten[i] = new Pruefling(IO.readString("Name: "));
                    Frage f = null;
            // alle Fragen der Pruefung stellen
            while ((f = this.pruefung.liefereNaechsteFrage()) !=
                    null) {
                f.frageStellen();
                f.frageBeantworten(this.studenten[i]);
            }
        }
    }
    void ergebnisseBekanntgeben() {
        this.ranglisteErstellen();
        IO.println("Pruefungsergebnisse");
        IO.println("-------------------");
        IO.println("Quiz: " + this.pruefung.getTitel());
        for (int i = 0; i < this.studenten.length; i++) {IO.println("Platz " + (i + 1) + ": " +
                        this.studenten[i].getName()
                        + " mit " + this.studenten[i].getPunkte() + " Punkten");
        }
    }
    private void ranglisteErstellen() {
        // Bubblesort nach erreichten Punkten
        boolean veraendert = false;
        do {
            veraendert = false;
            for (int i = 0; i < this.studenten.length - 1; i++) {
                if (this.studenten[i].getPunkte() <
                        this.studenten[i + 1]
                                .getPunkte()) {
                    Pruefling help = this.studenten[i];
                    this.studenten[i] = this.studenten[i + 1];
                    this.studenten[i + 1] = help;
                    veraendert = true;
                }
            }
        } while (veraendert);
    }
}