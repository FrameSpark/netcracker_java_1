package Sortings;

import Person.Person;

import java.util.Comparator;

public class ShakeSort extends Sort {
   public void sort(Person[] mas, Comparator<Person> comp) {
        int n=mas.length;
        int left = 1, right = n - 1;
        while (left <= right)
        {
            for (int i = left; i <= right; i++)
                if (comp.compare(mas[i - 1] , mas[i]) == 1)
                {
                    Person temp = mas[i - 1];
                    mas[i - 1] = mas[i];
                    mas[i] = temp;
                }
            right--;
            for (int i = right; i >= left; i--)
                if (comp.compare(mas[i - 1], mas[i]) == -1)
                {
                    Person temp = mas[i - 1];
                    mas[i - 1] = mas[i];
                    mas[i] = temp;
                }
            left++;
        }

    }
}
