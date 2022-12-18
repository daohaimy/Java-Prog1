import java.util.Random;
import java.util.Scanner;
public class Jan {
    public static void main(String[] args) {
        Jan j = new Jan();
        j.aufgabe1();
    }
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void aufgabe1(){
        int zufallZahl = random.nextInt(10)+1;
        System.out.println("Geben Sie eine Zahl ein: ");
        int zahl = scanner.nextInt();

        if(zahl == zufallZahl){
            System.out.println("Glückwunsch");
            System.out.println("Randomzahl ist: " + zufallZahl);
        }
        else {
            System.out.println("Schade");
            System.out.println("Randomzahl ist: " + zufallZahl);
        }
    }

    public void aufgabe2(){
        String[] i = new String[8];
        System.out.println("Geben sie 0, 1 ,2 ein:");
        int zahl = scanner.nextInt();
        while (zahl == 1 || zahl == 2) {
            System.out.println("1 ---> Eingabe");
            System.out.println("2 ---> Ausgabe");
            System.out.println("0 ---> Ende");
        }
    }
}
