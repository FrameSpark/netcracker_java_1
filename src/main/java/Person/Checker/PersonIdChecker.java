package Person.Checker;
import Person.Person;
/**
 * Created by strogonov_vg on 30.11.2018.
 */
public class PersonIdChecker implements Checker<Person> {


    public boolean check(Person o1, Object o2) {

        if(o1.getId() == (Integer)o2) return true;
        return false;
    }
}
