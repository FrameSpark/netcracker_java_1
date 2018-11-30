package Person.Checker;
import Person.Person;
/**
 * Created by strogonov_vg on 30.11.2018.
 */
public class PersonAgeChecker implements Checker<Person> {
    public boolean check(Person o1, Person o2) {

        if( o1.getAgeFromSet()- o2.getAge() ==  0)
            return true;
        return false;
    }
}
