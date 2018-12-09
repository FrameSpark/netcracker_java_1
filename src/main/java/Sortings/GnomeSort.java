package Sortings;

import Person.Person;

import java.util.Comparator;

public class GnomeSort implements Sort<Person> {
    public void sort(Person[] mas, Comparator<Person> comp) {
        int i = 1;
        int j = 2;
        int n = mas.length;
        Person buff;
        while (i < n)
            if (comp.compare(mas[i - 1], mas[i]) == -1) {
                i = j;
                j++;
            } else {
                buff = mas[i - 1];
                mas[i - 1] = mas[i];
                mas[i] = buff;
                i--;
                if (i == 0) {
                    i = j;
                    j++;
                }
            }
    }
}
