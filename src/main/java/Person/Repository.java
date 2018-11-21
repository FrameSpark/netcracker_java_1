package Person;

import java.util.Comparator;

public class Repository {
    private Person repos[];
    private Comparator<Person> compAge;
    private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Repository(int size){
            setSize(size);
            repos = new Person[size];
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
