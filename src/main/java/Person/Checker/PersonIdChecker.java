package Person.Checker;
import Person.Person;
/**
 * Created by strogonov_vg on 30.11.2018.
 */
public class PersonIdChecker implements Checker<Person> {


    public boolean check(Person o1, Person o2) {

        if(o1.getId() == o2.getId()) return true;
        return false;
    }
}