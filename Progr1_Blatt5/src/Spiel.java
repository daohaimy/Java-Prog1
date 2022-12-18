/**
 * Wï¿½rfelspiel Es wird gewettet, ob eine gerade oder ungerade Zahl gewï¿½rfelt
 * wird.
 *
 * Der Spieler erhï¿½lt ein Startguthaben. Es kï¿½nnen Wettbetrï¿½ge auf gerade und
 * ungerade gesetzt werden. Bei Gewinn/Verlust wird der gesetzte Betrag zum/vom
 * aktuellen Guthaben hinzugefï¿½gt/abgezogen Es kann gleichzeitig auf
 * gerade/ungerade gesetzt werden.
 *
 * Im Prinzip entspricht dieses Spiel dem Kopf/Zahl-Raten beim Werfen einer
 * Mï¿½nze.
 *
 * Die interaktive Steuerung geschieht durch GUI.
 *
 * TODO Erweiterung: Wetten auf einzelne Zahlen
 *
 * @author Friedhelm Tappe, Prof. Dr.-Ing. Heiko Tapken
 * @version 31.10.2022
 */
public class Spiel {
    Wuerfel wuerfel = new Wuerfel();
    private int startguthaben = 0;
    private int aktuellesGuthaben = 0;
    private int wettbetragGerade = 0;
    private int wettbetragUngerade = 0;
    EinUndAusgabe eingabe = new EinUndAusgabe();
    private Wuerfel einWuerfel;

    public Spiel(int guthaben, Wuerfel einWuerfel) {
        this.startguthaben = guthaben;
        this.aktuellesGuthaben = this.startguthaben;
        this.einWuerfel = einWuerfel;
    }

    public int wuerfeln() {
        einWuerfel.wuerfeln();
        return (einWuerfel.getOben());
    }

    public void init() {
        this.aktuellesGuthaben = startguthaben;
        this.wettbetragGerade = 0;
        this.wettbetragUngerade = 0;
        // todo
        // Initialisiere die globale Variable aktuellesGuthaben mit dem Wert von startguthaben
        // der Wettbetrag fï¿½r gerade und ungerade wird mit 0 initialisiert.
    }

    public void auswertenSpielzug(int gewuerfelteZahl) {
        switch (gewuerfelteZahl){
            case 1: case 3: case 5:
                this.aktuellesGuthaben += this.wettbetragUngerade;
                this.aktuellesGuthaben -= this.wettbetragGerade;
                break;
            case 2: case 4: case 6:
                this.aktuellesGuthaben += this.wettbetragGerade;
                this.aktuellesGuthaben -= this.wettbetragUngerade;
        }
        // todo
        // Diese Methode wird zur Auswertung eine Spielzugs aufgerufen.
        // Das aktuelle Guthaben (aktuellesGuthaben) wird aktualisiert in Abhï¿½ngigkeit davon ob.
        // Schreiben Sie ein Programm, dass die Variable aktuellesGuthaben in Abhï¿½ngigkeit vom Wert der
        // ï¿½bergebenen Variablen gewuerfelteZahl aktualisiert.
    }

    public int getStartguthaben() {
        return startguthaben;
    }

    public int getAktuellesGuthaben() {
        return aktuellesGuthaben;
    }

    public int getWettbetragGerade() {
        return wettbetragGerade;
    }

    public int getWettbetragUngerade() {
        return wettbetragUngerade;
    }

    public boolean setWettbetraege(int betragGerade, int betragUngerade) {
        this.wettbetragGerade = betragGerade;
        this.wettbetragUngerade = betragUngerade;

        if(betragGerade < 0 && betragUngerade < 0){
            return false;
        }
        else {
            return true;
        }
        // todo
        // betragGerade ist der auf gerade gesetzte Betrag
        // betragUngerade ist der auf ungerade gesetzte Betrag
        // Setze wettbetragGerade auf 0;
        // Setze wettbetragUngerade auf 0;

        // liefere false zurï¿½ck, falls ein negativer Betrag gesetzt wurde.
        // Das nach Abzug der Einsï¿½tze verfï¿½gbare Guthaben darf nicht negativ sein. Ist es negativ, liefert die Methode false zurï¿½ck.
        // sind die Einsï¿½tze gï¿½ltig, so werden wettbetragGerade und wettbetragUngerade auf den gesetzten betrag gesetzt und true zurï¿½ckgegeben.

        // muss nach Lï¿½sen der Aufgabe gelï¿½scht werden.
    }

}
