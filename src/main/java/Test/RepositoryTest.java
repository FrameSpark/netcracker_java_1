package Test;

import Person.Person;
import Person.Repository;
import Sortings.BubbleSort;
import Sortings.GnomeSort;
import Sortings.ShellSort;
import org.joda.time.LocalDate;

import static org.junit.Assert.assertEquals;


class RepositoryTest {

    private Repository r1;
    private Repository r2;
    private Repository r3;


    public void addPerson(Repository repo){


        repo.insertPerson(new Person(10,"Viacheslav",1,new LocalDate("1998-07-03")));
        repo.insertPerson(new Person(5,"Ivan",1,new LocalDate("1999-10-03")));
        repo.insertPerson(new Person(1,"Alex",1,new LocalDate("2000-11-03")));
        repo.insertPerson(new Person(6,"Ilia",1,new LocalDate("1997-07-04")));


    }


    @org.junit.jupiter.api.BeforeEach
    public void init(){
        r1 = new Repository(0,new BubbleSort());
        r2 = new Repository(0,new GnomeSort());
        r3 = new Repository(0,new ShellSort());


        addPerson(r1);
        addPerson(r2);
        addPerson(r3);

    }
    @org.junit.jupiter.api.Test
    public void sortByName() {
        r1.sortByName();
        assertEquals(r1.repos[0].getFullName(),"Alex");
        assertEquals(r1.repos[3].getFullName(),"Viacheslav");
        r2.sortByName();
        assertEquals(r2.repos[0].getFullName(),"Alex");
        assertEquals(r2.repos[3].getFullName(),"Viacheslav");
        r3.sortByName();
        assertEquals(r3.repos[0].getFullName(),"Alex");
        assertEquals(r3.repos[3].getFullName(),"Viacheslav");
    }

    @org.junit.jupiter.api.Test
    public void sortByAge() {

        r1.sortByAge();
        assertEquals(r1.repos[0].getAge(),18);
        assertEquals(r1.repos[3].getAge(),21);
        r2.sortByAge();
        assertEquals(r2.repos[0].getAge(),18);
        assertEquals(r2.repos[3].getAge(),21);
        r3.sortByAge();
        assertEquals(r3.repos[0].getAge(),18);
        assertEquals(r3.repos[3].getAge(),21);
    }

    @org.junit.jupiter.api.Test
    public void sortById() {
        r1.sortById();
        assertEquals(r1.repos[0].getId(),1);
        assertEquals(r1.repos[3].getId(),10);
        r2.sortById();
        assertEquals(r2.repos[0].getId(),1);
        assertEquals(r2.repos[3].getId(),10);
        r3.sortById();
        assertEquals(r3.repos[0].getId(),1);
        assertEquals(r3.repos[3].getId(),10);
    }


    @org.junit.jupiter.api.Test
    void searchByName() {
        Repository search = r1.searchByName("Viacheslav");
        assertEquals(search.repos[0].getFullName(), "Viacheslav");
    }

    @org.junit.jupiter.api.Test
    void searchByAge() {
        Repository search = r1.searchByAge(20);
        assertEquals(search.repos[0].getAge(), 20);
    }

    @org.junit.jupiter.api.Test
    void searchById() {
        Repository search = r1.searchById(10);
        assertEquals(search.repos[0].getId(), 10);
    }
}