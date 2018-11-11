

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

public class Person {
    private int id;
    private String fullName;
    private boolean gender;
    private int age;
    private LocalDate dateOfBirth;

    public int getId() {
        return id;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(String gender) {
        if(gender == "male"){
            this.gender = true;
        }
        else {
            this.gender = false;
        }
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
        if(nowDate.getDayOfMonth() - dateOfBirth.getDayOfMonth() <0 ){
            temp--;
        }
        return temp;
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



    public Person(int id, String fullName, String gender, LocalDate dateOfBirth) {
        this.setId(id);
        this.setFullName(fullName);
        this.setGender(gender);
        this.setDateOfBirth(dateOfBirth);
        this.setAge(getAge());
    }
}
