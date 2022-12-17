import java.util.Random;
public class SchnickSchnackSchnuck {
    Random random = new Random();
    EinUndAusgabe eingabe = new EinUndAusgabe();
    int computer;
    String Brunnen = "Brunnen";
    String Schere = "Schere";
    String Stein = "Stein";
    String Papier = "Papier";

    String Computer(){
        if(computer == 0){
            return Brunnen;
        }
        if (computer == 1) {
            return Schere;
        }
        if (computer == 2){
            return Stein;
        }
        if (computer == 3){
            return Papier;
        }
        return Computer();
    }

    void starte() {
        int computerErg = 0;
        int menschErg = 0;
        int spielrunde = 1;
        while (computerErg < 10 && menschErg < 10){
            System.out.println("______________________________________");
            System.out.println("Spielrunde: " + spielrunde);
            spielrunde++;
        Computer();
        System.out.println("Symbol eingeben (Brunnen, Schere, Stein, Papier): ");
        String mensch = eingabe.leseString();
        computer = random.nextInt(4);

        if ((computer == 0 && mensch.equals("Brunnen")) || (computer == 1 && mensch.equals("Schere")) || (computer == 2 && mensch.equals("Stein")) || (computer == 3 && mensch.equals("Papier"))){
            System.out.println("Computer: " + Computer());
            System.out.println("Spielstand: " + "Computer = " + computerErg + "; Mensch = " + menschErg);
        }
        else if((computer == 0 && (mensch.equals("Stein") || mensch.equals("Schere"))) || (computer == 1 && (mensch.equals("Papier"))) || (computer == 2 && mensch.equals("Schere")) || (computer == 3 && (mensch.equals("Stein") || mensch.equals("Brunnen")))){
            computerErg++;
            System.out.println("Computer: " + Computer());
            System.out.println("Spielstand: " + "Computer = " + computerErg + "; Mensch = " + menschErg);
        }
        else if ((mensch.equals("Brunnen") && (computer == 1 || computer == 2)) || (mensch.equals("Schere") && computer == 3) || (mensch.equals("Stein") && computer == 1) || (mensch.equals("Papier") && (computer == 2 || computer == 0))){
                menschErg++;
                System.out.println("Computer: " + Computer());
                System.out.println("Spielstand: " + "Computer = " + computerErg + "; Mensch = " + menschErg);
            }
        else{
            spielrunde = spielrunde - 1;
            System.out.println("falsche Eingabe!");
        }
    }
        if(computerErg == 10){
            System.out.println("______________________________________");
            System.out.println("Spielende: Computer hat gewonnen");
        }
        else if(menschErg == 10){
            System.out.println("______________________________________");
            System.out.println("Spielende: Sie haben gewonnen");
        }
}
}

