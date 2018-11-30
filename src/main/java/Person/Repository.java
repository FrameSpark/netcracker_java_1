package Person;



import Person.Checker.Checker;
import Person.Checker.PersonAgeChecker;
import Person.Checker.PersonIdChecker;
import Person.Checker.PersonNameChecker;
import Person.Comparators.PersonAgeComparator;
import Person.Comparators.PersonIdComparator;
import Person.Comparators.PersonNameComparator;
import Sortings.Sort;
import org.joda.time.LocalDate;
import java.util.Comparator;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class Repository {
    public Person repos[];
   // private static final Logger log = Logger.getLogger("Repository.class");
    private final Logger log = LogManager.getRootLogger();
    private Comparator<Person> compAge = new PersonAgeComparator();
    private Comparator<Person> compName = new PersonNameComparator();
    private Comparator<Person> compId = new PersonIdComparator();
    private Checker<Person> checkAge = new PersonAgeChecker();
    private Checker<Person> checkId = new PersonIdChecker();
    private Checker<Person> checkName = new PersonNameChecker();
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
            log.info("Репозиторий создан!");
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
            log.info("Отсортировано по имени!");

        }

        public void sortByAge(){
            sorting(repos,compAge);
            log.info("Отсортировано по возрасти!");
        }
        public void sortById(){
            sorting(repos,compId);
            log.info("Отсортировано по идентификатору!");
        }

    /**
     * check*
     * Функция сравнения определенного значения. Если true, то совпадение.
     */

    private boolean seacrh(Checker<Person> checker, Person one, Person two){

       return checker.check(one,two);
    }

    public Repository searchByName(String name){
            Person temp = new Person(1,name,1,new LocalDate("2010-10-10"));
             Repository tempRep = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(seacrh(checkName,temp,repos[i])){
                tempRep.insertPerson(repos[i]);
            }
        }
        return tempRep;
    }

    public Repository searchByAge(int value){
        Person temp = new Person(1,"temper",1,new LocalDate("2010-10-10"));
        temp.setAge(value);
        Repository tempRep = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(seacrh(checkAge,temp,repos[i])){
                tempRep.insertPerson(repos[i]);
            }
        }
        return tempRep;
    }
    public Repository searchById(int value){
        Person temp = new Person(value,"temper",1,new LocalDate("2010-10-10"));
        Repository tempRep = new Repository(0);
        for(int i=0;i<getSize();i++) {
            if(seacrh(checkId,temp,repos[i])){
                tempRep.insertPerson(repos[i]);
            }
        }
        return tempRep;
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
            log.info("Персонаж добавлен! Текущий размер: " + size);
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
            log.error("Был запрошен индекс вне размерности! Зпрошено: " + index + " Размер: " + size);
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
            log.info("Персонаж удален! Текущий размер: " + size);
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
