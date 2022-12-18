import java.util.ArrayList;

public class HaiMyDao {

    String student = "Hai My Dao";
    ArrayList <String> namen = new ArrayList<String>();

    public static void main(String[] args) {
        String teacher = "Hendrik Pitzer";
        System.out.println(teacher);

        HaiMyDao zt = new HaiMyDao();
        zt.istZahlgerade(5);
        System.out.println("ArrayList");
        zt.namen = zt.init();
        zt.ausgeben(zt.getNamen());
        zt.ausgeben(zt.getNamen(), 2,9);
    }

    public String getStudent(){
        return student;
    }

    public ArrayList<String> getNamen(){
        return namen;
    }

    public void setNamen(int index, String name) {
        this.namen.set(index, name);
    }

    public boolean istZahlgerade(int i){
        int zahl = (int)((Math.random()) * i + 1);
        if(zahl % 2 == 0){
            System.out.println("Zahl ist gerade");
            return true;
        }
        else {
            System.out.println("Zahl ist ungerade");
            return false;
        }
    }

    ArrayList<String> init(){
        String vorname = "Hai My";
        String nachname = "Dao";
        namen.add(vorname);
        namen.add(nachname);

        for(int j = 0; j < namen.size(); j++){
            System.out.println(namen.get(j));
        }
        return namen;
    }

    public void ausgeben(ArrayList<String> strings){
        for (int i = 0; i < strings.size(); i++) {
            System.out.print(strings.get(i));
            System.out.print(" ");
        }
    }

    public void ausgeben(ArrayList<String> strings, int min, int max){
        min = (int)((Math.random()) * min + 1);
        if(min >= 1 && max <= 10){
            for (int i = 0; i < min; i++){
                for(int j = 0; j < strings.size(); j++) {
                    if (j == 0){
                        System.out.println(" ");
                    }
                    System.out.print(strings.get(j));
                    System.out.print(" ");
                }
            }
        }
    }

    /*
    public ArrayList<String> getNamen(){
        String vorname = "Hai My";
        String nachname = "Dao";
        ArrayList<String> meinName = new ArrayList<String>();
        meinName.add(vorname);
        meinName.add(nachname);
        return meinName;
    }

     */
}

