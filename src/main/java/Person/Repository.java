package Person;

import Person.Comparators.PersonAgeComparator;
import Person.Comparators.PersonIdComparator;
import Person.Comparators.PersonNameComparator;
import Sortings.Sort;

import java.util.Comparator;

public class Repository {
    public Person repos[];
    private Comparator<Person> compAge = new PersonAgeComparator();
    private Comparator<Person> compName = new PersonNameComparator();
    private Comparator<Person> compId = new PersonIdComparator();
    private Sort sorter;
    private int size;

        public int getSize() {
            return size;
        }
        public void setSize(int size) {
            this.size = size;
        }

        public Repository(int size, Sort typeSort){
            setSize(size);
            repos = new Person[size];
            sorter = typeSort;
        }
        private Repository(int size)
        {
            this.size = size;
        }

        private void sorting(Person repos[],Comparator<Person> comp){
            sorter.sort(repos,comp);
        }

        public void sortByName(){
            sorting(repos,compName);
        }

        public void sortByAge(){
            sorting(repos,compAge);
        }
        public void sortById(){
            sorting(repos,compId);
        }

    /**
     * check*
     * Функция сравнения определенного значения. Если true, то совпадение.
     */
        private boolean checkName(String name,Person person)
        {
            Person temp = new Person();
            temp.setFullName(name);
            if(compName.compare(temp,person) ==  0)
                return true;
            return false;
        }
        private boolean checkAge(int value, Person person){
            Person temp = new Person();
            temp.setAge(value);
            if(compAge.compare(temp,person) ==  0)
                return true;
            return false;
        }
        private boolean checkId(int value, Person person){
            Person temp = new Person();
            temp.setAge(value);
            if(compId.compare(temp,person) ==  0)
                return true;
            return false;
        }

    public Repository searchByName(String name){
            Repository temp = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(checkName(name,repos[i])){
                temp.insertPerson(repos[i]);
            }
        }
        return temp;
    }

    public Repository searchByAge(int value){
        Repository temp = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(checkAge(value,repos[i])){
                temp.insertPerson(repos[i]);
            }
        }
        return temp;
    }
    public Repository searchById(int value){
        Repository temp = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(checkId(value,repos[i])){
                temp.insertPerson(repos[i]);
            }
        }
        return temp;
    }


    /**
     * Добавление человека в репозиторий
     * @param newPerson Объект человек
     */
    public void insertPerson(Person newPerson){
            setSize(this.getSize() + 1);
            Person temp[]=new Person[getSize()];
            for(int i=0; i<getSize()-1;i++){
                temp[i] = repos[i];
            }
            temp[getSize()-1] = newPerson;
            repos = temp;
        }

    /**
     * Проверка индекса на вход в диапазон массива
     * @param index
     * @return true если входит
     */
    private boolean inRange(int index){
        if(index < getSize() && index >0){
            return true;
        }
        else{
            return false;
            }
        }

    /**
     * Возвращает человека по индексу
     * @param i
     * @return
     */
    public void showPersonByIndex(int i){
        if(inRange(i)){
            repos[i].showPerson();
        }

        }

    /**
     * Замена человека по индексу
     * @param newPerson
     * @param index
     */
    public void changePersonByIndex(Person newPerson, int index) {
        if (inRange(index)) {
            repos[index] = newPerson;
        }
    }

    /**
     * Удаление человека по индексу
     * @param index
     */

        public void deletePersonByIndex(int index){
            if(inRange(index)){
                size--;
                Person temp[]=new Person[size];
                for(int i=0,j=0; i<size; i++, j++ ){
                    if(j == index)
                    {
                        j++;
                    }
                    temp[i] = repos[j];
                }
                repos = temp;
            }
        }


    /**
     * Вывод всего репозитория
     *
     */
    public void showArray(){
        for(int i=0; i<size;i++){
            repos[i].showPerson();
        }
    }
}
