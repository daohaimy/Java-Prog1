 import java.util.Random;
/**
     * Simulation eines 6-seitigen Wï¿½rfels
     * Die oben liegende Zahl ist die gewï¿½rfelte Zahl
     *
     * TODO
     * Verallgemeinerung auf beliebige "Wï¿½rfel"
     *
     * @author Friedhelm Tappe, Prof. Dr.-Ing. Heiko Tapken
     * @version 31.10.2022
     *
     */

    public class Wuerfel {
        Random random = new Random();
        private int gewuerfelteZahl;

        public Wuerfel() {
            this.wuerfeln();
        }

        public Wuerfel(int oben) {
            this.gewuerfelteZahl = oben;
        }

        public void wuerfeln() {
            this.gewuerfelteZahl = random.nextInt(6)+1;
            //todo:
            //weisen Sie der Variablen gewuerfelteZahl wir ein zufï¿½lliger Wert zwischen 1 und 6 (Integer) zu
        }

        public int getOben() {
            return gewuerfelteZahl;
        }

    }
