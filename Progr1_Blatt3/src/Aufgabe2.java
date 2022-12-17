public class Aufgabe2 {
    void starte() {
        boolean a;
        boolean b;
        a = true;
        b = true;
        System.out.println((!(a && b) && (a || b)) || ((a && b) || !(a || b)));
        a = true;
        b = false;
        System.out.println((!(a && b) && (a || b)) || ((a && b) || !(a || b)));
        a = false;
        b = true;
        System.out.println((!(a && b) && (a || b)) || ((a && b) || !(a || b)));
        a = false;
        b = false;
        System.out.println((!(a && b) && (a || b)) || ((a && b) || !(a || b)));
    }
}
