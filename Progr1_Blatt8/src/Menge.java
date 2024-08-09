import java.util.ArrayList;
import java.util.Objects;
public class Menge{
    public static void main(String[] args) {
    }


    ArrayList<Person> people = new ArrayList<>();

    public ArrayList<Person> getPeople() {
        return people;
    }
    // a)
    public ArrayList<Person> leereMenge (){
        return new ArrayList<>();
    }
    // b)
    public Menge(Menge menge){
        this.people = menge.people;
    }
    // c)
    public boolean gleichheit (ArrayList<Person> liste1, ArrayList<Person> liste2){
        for (int i = 0; i < liste1.size(); i++){
            for (int j = 0; j < liste2.size(); j++){
                if (Objects.equals(liste1.get(i), liste2.get(j))){
                    return true;
                }
            }
        }
        return false;
    }
    // d)
    public ArrayList<Person> addPerson(Person person) {
        people.add(person);
        return people;
    }
    // e)
    public ArrayList<Person> removePerson(Person person) {
        people.remove(person);
        return people;
    }
}
