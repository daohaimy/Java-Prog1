import java.util.Random;
import java.util.Scanner;
public class Uebung {
    public static void main(String[] args) {
        Uebung u = new Uebung();
        u.jona();

        }

        //Scanner s = new Scanner(System.in);
    public void jona(){
        int tag;
        Random random = new Random();
        tag = random.nextInt(31) + 1;
        if (tag == 24) {
            System.out.println(tag + ".12.2022");
            System.out.println("Frohe Weihnachten!");
        } else {
            System.out.println(tag + ".12.2022");
        }
    }

    public void jannik(){

    }
}
