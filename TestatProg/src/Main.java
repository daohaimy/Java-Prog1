public class Main {
    public void start() {
/*        Konto k1 = new Konto();
        Konto k2 = new Konto();

        k1.setKontostand(123);
        Konto k3 = new Konto(k1);

        System.out.println(k1 == k3);
        System.out.println(k1.equals(k3));

        System.out.println(k1.getKontostand());*/

        Bank bank = new Bank();

        Konto k1 = bank.erstelleKonto();
        k1.setKontostand(400.0);
        bank.erstelleKonto();
        bank.erstelleKonto();
        bank.erstelleKonto();

        Konto k2 = bank.sucheKonto(567);
        if(k2 != null) {
            k2.setKontostand(100);
        }

        Konto k3 = bank.sucheKonto(102);

        System.out.println(bank.auszahlen(k1, 1000.0));
        System.out.println(bank.auszahlen(k1, 1000.0));
        System.out.println(k1.getKontostand());

        System.out.println(bank.auszahlen(101, 500.0));

        bank.erstelleKonto(1000);
        Konto k123 = bank.sucheKonto(123);

    }

    public static void main(String[] args) {
        new Main().start();
    }

}