import java.util.ArrayList;
public class Aufgabe2 {
    double a;
    double b;
    double c;
    double d;
    static int x;
    boolean isPrimzahl = true;
    EinUndAusgabe eingabe = new EinUndAusgabe();

    //  (1)
    void fibonacci(int x) {
        boolean b = true;
        if (x == 0) {
            System.out.println(b);
        } else if (x == 1) {
            System.out.println(b);
        } else if (x > 1 && fib(x) == x) {
            System.out.println(b);
        } else {
            System.out.println(!b);
        }
    }

    int fib(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            b = a + (a = b);
            if (b == n) {
                return n;
            }
        }
        return -1;
    }

    //  (2)
    void tauschen(double a, double b) {
        c = a;
        d = b;
        b = c;
        a = d;
        System.out.println("Ergebnis: a==" + a + "; b==" + b);
    }

    //  (3)
    void aufrunden(double x) {
        if (x < 0) {
            x = (x - 1) * (-1);
        } else {
            x = x + 1;
        }
        System.out.println((int) x);
    }

    //  (4)
    public int naechstePrimzahl(int x) {
        x = x-1;
        for (int i = 2; i <= x; i++) {
            for (int j = 2; j < i; j++) {
                if ((i % j) == 0) {
                    x = x-1;
                    naechstePrimzahl(x);
                }
                else {
                    System.out.println(x);
                    return x;
                }
            }
        }
        return x;
    }


}

