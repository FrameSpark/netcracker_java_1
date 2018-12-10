package Person;



import Person.Annotaion.AutoInjectable;
import Person.Checker.Checker;
import Person.Checker.PersonAgeChecker;
import Person.Checker.PersonIdChecker;
import Person.Checker.PersonNameChecker;
import Person.Comparators.PersonAgeComparator;
import Person.Comparators.PersonIdComparator;
import Person.Comparators.PersonNameComparator;
import java.util.Comparator;
import Sortings.Sort;
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

    @AutoInjectable
    public Sort<Person> sorter;

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
        public Repository(int size)
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

   private Person[] seacrh(Checker<Person> checker, Person[] repos, Object s){
        Repository temp = new Repository(0);
        for(int i=0;i<repos.length;i++) {
            if(checker.check(repos[i],s)){
                temp.insertPerson(repos[i]);
            }
        }
        return temp.repos;

    }

    public Person[] searchByName(String name){
        return seacrh(checkName, repos, name );
      }

    public Person[] searchByAge(int value){
        return seacrh(checkAge, repos, new Integer(value));
    }
    public Person[] searchById(int value){
        return seacrh(checkId, repos, new Integer(value) );
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
