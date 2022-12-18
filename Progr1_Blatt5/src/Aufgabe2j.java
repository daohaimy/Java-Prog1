import java.util.Scanner;

public class Aufgabe2j {
    public static void aufgabe2j(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wählen sie einen Float: ");
        float uhr1 = scanner.nextFloat();

        System.out.println("Wählen sie einen 2ten Float: ");
        float uhr2 = scanner.nextFloat();

        System.out.println(uhrzeit(uhr1, uhr2));


    }
    public static float uhrzeit(float uhr1, float uhr2){
        int stunden1 = (int) uhr1;
        int stunden2 = (int) uhr2;
        int stunden = stunden1 + stunden2;
        if(stunden > 24) {
            stunden = stunden - 24;
        }
        return stunden;


  /*      uhr1 = uhr1 * 1000;
        int uhrRechnen1 = (int) uhr1 - (minus1 * 1000);
        uhr2 = uhr2 * 1000;
        int uhrRechnen2 = (int) uhr2 - (minus2 * 1000);
        int stunden = (uhrRechnen2 + uhrRechnen1);
      */
    }
}
