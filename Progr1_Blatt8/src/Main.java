public class Main {
    public static void main(String[] args) {
        Konto k1 = new Konto (123, "Hai My Dao", 1000.0, 0.0);
        Konto k2 = new Konto (122, "Kevin Siofer", 1100.0, 0.0);

        k1.einzahlen(9100.0);
    }
}