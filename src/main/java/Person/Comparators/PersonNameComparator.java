package Person.Comparators;

import Person.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
    int res = o1.getFullName().compareTo(o2.getFullName());
    if(res < 0) return -1;
    if(res > 0) return 1;
    if(res == 0) return 0;
    return 0;

    }
}
