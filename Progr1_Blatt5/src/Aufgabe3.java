import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Aufgabe3 {
    EinUndAusgabe eingabe = new EinUndAusgabe();

    int falkultaet(int x) {
        int zahl = 1;
        if (x == 0) {
            return 1;
        } else {
            for (int i = 1; i <= x; i++) {
                zahl = zahl * i;
            }
            return zahl;
        }
    }

    // a)
    public int binomialkoeffizienten(int n, int k) {
        int n1 = falkultaet(n);
        int y = n - k;
        int k1 = falkultaet(k) * falkultaet(y);
        int z = n1 / k1;
        //System.out.println("Binomialkoeffizient: " + z);
        return z;
    }

    // b)
    public void pascalscherDreiecke(int n, int k) {
        int x =  binomialkoeffizienten(n, k) + binomialkoeffizienten(n, k+1);
        System.out.println(x);
    }

    // c)
    public void textMenue() {
        System.out.println("n = ");
        int n = eingabe.leseInteger();
        int i = 0;
        int j;
            for (i = 0; i <= n; i++) {
                for (j = 0; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (j = 0; j <= i; j++) {
                    System.out.print(" " + binomialkoeffizienten(i,j));
                }
                System.out.println();
                }
        }
    }

