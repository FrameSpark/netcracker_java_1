package Sortings;

import Person.Person;

import java.util.Comparator;

public class BubbleSort implements Sort<Person> {
    public void sort(Person[] mas, Comparator<Person> comp) {
        for (int i = mas.length - 1; i >= 0; i--)
            for (int j = 0; j < i; j++)
                if (comp.compare(mas[j],mas[j+1]) == 1)
                {
                    Person tmp = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = tmp;
                }
    }
}
