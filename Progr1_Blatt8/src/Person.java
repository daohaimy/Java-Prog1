import java.util.Objects;
public class Person {
    String nachname;
    String vorname;
    public Person(String nachname, String vorname){
        this.nachname = nachname;
        this.vorname = vorname;
    }

    public String getNachname(){
        return nachname;
    }
    public void setNachname(String nachname){
        this.nachname = nachname;
    }

    public String getVorname(){
        return vorname;
    }
    public void setVorname(String vorname){
        this.vorname = vorname;
    }

    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() == this.getClass()) {
            Person p = (Person) obj;
            if (Objects.equals(this.getVorname(), p.getVorname()) && this.getNachname().equals(p.getNachname())) {
                return true;
            }
        }
        return false;
    }
}
