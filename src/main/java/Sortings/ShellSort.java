package Sortings;

import Person.Person;

import java.util.Comparator;

public class ShellSort implements Sort<Person> {
   public void sort(Person[] mas, Comparator<Person> comp) {

       int i, j, k, n=mas.length;
        Person t;
       for (k = n / 2; k > 0; k /= 2)
           for (i = k; i < n; i++)
           {
               t = mas[i];
               for (j = i; j >= k; j -= k)
               {
                   if (comp.compare(t,mas[j-k]) == -1)
                       mas[j] = mas[j - k];
                   else
                       break;
               }
               mas[j] = t;
           }

    }
}
