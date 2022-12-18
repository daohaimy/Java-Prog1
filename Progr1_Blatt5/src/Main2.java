import java.io.IOException;

/**
 *
 * @author Prof. Dr. Heiko Tapken
 * @version 31.10.2022
 */

public class Main2 {

    public static void main(String[] args) throws IOException {

        Wuerfel einWuerfel = new Wuerfel();
        Spiel einSpiel = new Spiel(1000, einWuerfel);
        GUI einGUISpiel = new GUI(einSpiel);


    }

}

