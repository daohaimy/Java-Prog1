public class Tapken1 {
    public void schleifeInSchleife(){

        for (int zaehler = 0; zaehler < 5;zaehler = zaehler + 1){
            for (int zaehler2 = 20;zaehler2 < 25;zaehler2 = zaehler2 + 1){
                System.out.print(zaehler+":"+zaehler2+" ");
            }
            System.out.println("");
        }
    }

    public void schleifeInSchleife_while(){
        int zaehler = 0;
        while (zaehler < 5){
            int zaehler2 = 20;
            while (zaehler2 < 25){
                System.out.print(zaehler+":"+zaehler2+" ");
                zaehler2 = zaehler2 + 1;
            }
            zaehler = zaehler + 1;
            System.out.println("");
        }
    }

    public void starte() {
        schleifeInSchleife();
    }
}

