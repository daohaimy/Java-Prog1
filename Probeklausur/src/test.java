public class test {
    public static void main(String[] args) {
        // a)
        EinUndAusgabe ea = new EinUndAusgabe();
        int[][] m = {{7, 4, 2, 2},
                     {6, 3, 2, 7},
                     {1, 9, 0, 5}};
        System.out.println("Bei der Eingabe von :");
        int w = ea.leseInteger();
        System.out.println(m[m[1][w]][m[w][2]]);
        /*
    Bei der Eingabe von 2: 1
    Bei der Eingabe von 1: Fehler
     */


        int zahl = 5;
        while (f(zahl) > 0){
            zahl--;
            System.out.print(zahl);
        }
    }
        static int f(int zahl){
            zahl--;
            return zahl;
        }
}
