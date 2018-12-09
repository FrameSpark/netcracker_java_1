package Person.Checker;
import Person.Person;
/**
 * Created by strogonov_vg on 30.11.2018.
 */
public class PersonNameChecker implements Checker<Person> {
    public boolean check(Person o1, Object o2) {
        int res = o1.getFullName().compareTo((String)o2);
        if(res ==0) return true;
        return false;
    }
}
