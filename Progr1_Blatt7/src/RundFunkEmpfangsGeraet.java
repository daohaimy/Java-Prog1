public class RundFunkEmpfangsGeraet {
    public static void main(String[] args) {
        Radio r = new Radio();
        Fernseher f = new Fernseher();
        RundFunkEmpfangsGeraet rfeg = new RundFunkEmpfangsGeraet();
        rfeg.volume(5);
        rfeg.an();
        rfeg.volume(5);
        rfeg.volume(-2);
        rfeg.lauter();
        rfeg.aus();
        rfeg.leiser();
        r.volume(-1);
        System.out.println(rfeg);


    }
    int lautstaerke = 0;
    boolean eingeschaltet = false;
    RundFunkEmpfangsGeraet() {
    }
    /**
     * verändere Lautstaerke um x nach oben oder unten, je nach
     Vorzeichen von x
     */
    void volume(int x) {
        if (!eingeschaltet){
            System.out.println("Das Gerät ist noch nich an");
        }
        else if(x > 0 && lautstaerke >= 0){
            lautstaerke = x + lautstaerke;
            System.out.println("Lautstärke: " + lautstaerke);
        }
        else if (x < 0 && lautstaerke >= 0 && lautstaerke + x >= 0){
            for(int i = 1 ; i < lautstaerke; i++) {
                lautstaerke--;
            }
            System.out.println("Lautstärke: " + lautstaerke);
        }
        else if (x < 0 && lautstaerke >= 0 && lautstaerke + x < 0){
            System.out.println("x ist größer als lautstärke, kann nicht " + x + " mal leiser machen");
            System.out.println("höchsten: -" + lautstaerke);
        }
    }
    /** Erhöhe Lautstaerke um 1 */
    void lauter() {
        if(eingeschaltet) {
            lautstaerke++;
            System.out.println("Lautstärke um 1 lauter: " + lautstaerke);
        }
        else {
            System.out.println("Das Gerät ist noch nich an");
        }
    }
// getter und setter
    /** Vermindere Lautstaerke um 1. */
    void leiser() {
        if (eingeschaltet) {
            lautstaerke--;
            System.out.println("Lautstärke um 1 leiser: " + lautstaerke);
        }
        else {
            System.out.println("Das Gerät ist noch nich an");
        }
    }
    /** Schalte ein. */
    void an() {
        eingeschaltet = true;
        System.out.println("eingeschaltet!");
    }
    /** Schalte aus */
    void aus() {
        eingeschaltet = false;
        System.out.println("ausgeschaltet!");
    }
    /** an oder aus? */
    boolean istAn() {
        if(eingeschaltet) {
            System.out.println("Das Gerät ist an");
            return true;
        }
        else {
            System.out.println("Das Gerät is nicht an");
            return false;
        }
    }
}

class Radio extends RundFunkEmpfangsGeraet{
    double frequenz = 87.5;
    void wahleSender(double newFrequenz){
        if(eingeschaltet) {
            this.frequenz = newFrequenz;
        }
        else {
            System.out.println("Das Gerät ist noch nicht an");
        }
    }
    Radio(){

    }

}

class Fernseher extends RundFunkEmpfangsGeraet{
    int kanal = 1;
    void waehleKanal(int newKanal){
        if(istAn()){
            this.kanal = newKanal;
        }
    }
    Fernseher(){
    }
}