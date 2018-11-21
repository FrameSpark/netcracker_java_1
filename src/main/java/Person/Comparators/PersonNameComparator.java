package Person.Comparators;

import Person.Person;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {

    public int compare(Person o1, Person o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
}
