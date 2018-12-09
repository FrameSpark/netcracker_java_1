package Person.Checker;
import Person.Person;
/**
 * Created by strogonov_vg on 30.11.2018.
 */
public interface Checker<Person> {
    boolean check(Person o1, Object o2);
}
