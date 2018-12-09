package Sortings;

import Person.Person;

import java.util.Comparator;

public interface Sort<Person> {
    void sort(Person mas[], Comparator<Person> comp);
}
