import java.util.Date;
import java.time.LocalDate;

public class Geburtsdatum {
    LocalDate today = LocalDate.now();
    int tag;
    int monat;
    int jahr;

    public int getTag(){
        return tag;
    }
    public int getMonat(){
        return monat;
    }
    public int getJahr(){
        if (tag == 29 && monat == 2){
            if (jahr % 400 == 0 && jahr % 4 == 0){
                return jahr;
            }
            else{
                System.out.println("Der Datum existiert nicht.");
            }
        }
        return jahr;
    }

    public Geburtsdatum(int tag, int monat, int jahr){
        this.tag = tag;
        this.monat = monat;
        this.jahr = jahr;
    }
}
