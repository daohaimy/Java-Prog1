public class JonaKipke {

    String[] namen;
    String student = "Jona Kipke";

    public static void main (String[] args){
        String teacher = "Martin Landwehr";
        JonaKipke zt = new JonaKipke();
        zt.adventsKalender();
        System.out.println("Array");
        zt.namen = zt.init();
        zt.ausgeben(zt.getNamen());
        zt.ausgeben(zt.getNamen(), 9);

    }

    public void setNamen(String[] namen) {
        this.namen = namen;
    }

    public String[] getNamen() {
        return namen;
    }

    public void adventsKalender(){
        int zufallszahl = (int)((Math.random()) * 26 + 1);
        System.out.println("Heute ist der " + zufallszahl + ".Dezember.");
        if(zufallszahl==6){
            System.out.println("Alles Gute zum Nikolaus");
        } else if (zufallszahl>=24 && zufallszahl<=26) {
            System.out.println("Frohe Weihnachten");
        } else {
            System.out.println("schöne Adventszeit");
        }
    }

    public String[] init(){
        String vorname = "Jona";
        String nachname = "Kipke";
        String[] stringArray = new String[2];
        stringArray[0] = vorname;
        stringArray[1] = nachname;
        return stringArray;
    }

    public void ausgeben(String[] stringArray){
        for (int a = 0; a< stringArray.length; a++){
            System.out.println(stringArray[a]);
        }
    }

    public void ausgeben(String[] stringArray, int n){
        String name = stringArray[0] + " " + stringArray[1];
        int zufallszahl = 1;
        while (zufallszahl != n) {
            if (n>=1 && n<=10){
                System.out.println(name);
            }
            zufallszahl = (int)((Math.random()) * 10 + 1);
        }
    }

}
