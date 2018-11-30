

package Person;

import org.joda.time.LocalDate;



/**
 * Класс хранит информацию о человеке.
 * id - идентификатор человека
 * fullName - полное имя человека
 * gender - пол человека (true-male , false- female)
 * age - возраст в годах
 * dateOfBirth - дата рождения
 */

public class Person{
    private int id;
    private String fullName;
    private int gender;
    private int age;
    private LocalDate dateOfBirth;



    public int getId() {
        return id;
    }

    public int getGender(){
        return this.gender;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public void setGender(int gender) {
        this.gender = gender;
    }

    /**
     * Возраст вычисляется вычитанием лет из текущей даты даты рождения. Так же происходит проверка, не было ли в этом
     * года дня рождения.
     * @return
     */
    public int getAge() {

        LocalDate nowDate = LocalDate.now();
        int temp = nowDate.getYear() - dateOfBirth.getYear();
        if(nowDate.getMonthOfYear() - dateOfBirth.getMonthOfYear() < 0) {
            temp--;
        }
        if(nowDate.getMonthOfYear() - dateOfBirth.getMonthOfYear() == 0){
        if(nowDate.getDayOfMonth() - dateOfBirth.getDayOfMonth() <0 ){
            temp--;
        }
        }
        return temp;
    }

    public int getAgeFromSet(){
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Конструктор
     * @param id
     * @param fullName
     * @param gender
     * @param dateOfBirth
     */

    public Person(int id, String fullName, int gender, LocalDate dateOfBirth) {
        this.setId(id);
        this.setFullName(fullName);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setAge(getAge());
    }
    public Person(){

    }

    void showPerson(){
        System.out.println(getId() + " " + getFullName() + " isMale "  + getGender()+ " Age: "+ getAge() + " " +getDateOfBirth());
    }



}

