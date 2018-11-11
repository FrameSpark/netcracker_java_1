package Person;

public class Repository {
    private Person repos[];
    private int size;

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Repository(int size){
            this.setSize(size);
            repos = new Person[size];
        }

    /**
     * Добавление человека в репозиторий
     * @param newPerson Объект человек
     */
    public void insertPerson(Person newPerson){
            this.setSize(this.getSize() + 1);
            Person temp[]=new Person[this.getSize()];
            for(int i=0; i<this.getSize()-1;i++){
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
        if(index < this.getSize() && index >0){
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
            System.out.println(repos[i].getId() + " " + repos[i].getFullName() + " " + repos[i].getAge() + " " +repos[i].getDateOfBirth());
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
                this.size--;
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


    public void showArray(){
        for(int i=0; i<size;i++){
            System.out.println(repos[i].getId() + " " + repos[i].getFullName() + " " + repos[i].getAge() + " " +repos[i].getDateOfBirth());

        }
    }
}
