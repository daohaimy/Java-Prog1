public class Konto {
int nummer;
String inhaber = "anonym";
double betrag;

    Konto(int nummer, String inhaber) {
         this.nummer = nummer;
         this.inhaber = inhaber;
         this.betrag = 0.0;
         }

         Konto(int nummer) {
         this.nummer = nummer;
         }
         public int getNummer() {
         return nummer;
        }
         public void setNummer(int nummer) {
         this.nummer = nummer;
         }

         public String getInhaber() {
         return inhaber;
         }

         public void setInhaber(String inhaber) {
         this.inhaber = inhaber;
         }

         public double getBetrag() {
         return betrag;
         }

         public void setBetrag(double betrag) {
         this.betrag = betrag;
         }

         public void einzahlen(double wert) {
         this.betrag = this.betrag + wert;
         }

        public void abbuchen(double betrag) {
        this.betrag = this.betrag -betrag;
         }
         /*
         Konto k1 = new Konto(42,"ich");
        Konto k2 = new Konto(43);
        k1.einzahlen(200.00);
        k2.setBetrag(100.00);
        Double diff = k1.getBetrag()
                - k2.getBetrag();
        k2.abbuchen(diff);
        k1.einzahlen(k1.getBetrag());
        k2.abbuchen(k1.getBetrag());

        System.out.println(k1.betrag + " und " + k2.betrag);
          */
 }
