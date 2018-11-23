package Test;

import Person.Person;
import Person.Repository;
import Sortings.BubbleSort;
import Sortings.GnomeSort;
import Sortings.ShakeSort;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.joda.time.LocalDate;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class RepositoryTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Person.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private Repository r1;
    private Repository r2;
    private Repository r3;


    public void addPerson(Repository repo){


        repo.insertPerson(new Person(10,"Viacheslav",1,new LocalDate("1998-07-03")));
        repo.insertPerson(new Person(5,"Ivan",1,new LocalDate("1999-10-03")));
        repo.insertPerson(new Person(1,"Alex",1,new LocalDate("2000-11-03")));
        repo.insertPerson(new Person(6,"Ilia",1,new LocalDate("1997-07-04")));


    }

    @Before
    public void init(){
        r1 = new Repository(0,new BubbleSort());
        r2 = new Repository(0,new GnomeSort());
        r3 = new Repository(0,new ShakeSort());
        addPerson(r1);
        addPerson(r2);
        addPerson(r3);
    }
    @org.junit.Test
    public void sortByName() {
    }

    @org.junit.Test
    public void sortByAge() {
        r1.sortByAge();
        assertEquals(r1.repos[0].getAge(),21);
        assertEquals(r1.repos[3].getAge(),18);
    }

    @org.junit.Test
    public void sortById() {
        r1.sortById();
        assertEquals(r1.repos[0].getId(),1);
        assertEquals(r1.repos[3].getId(),10);
    }

    @org.junit.Test
    public void searchByName() {
    }

    @org.junit.Test
    public void searchByAge() {
    }

    @org.junit.Test
    public void searchById() {
    }

    @org.junit.Test
    public void insertPerson() {

    }

    @org.junit.Test
    public void changePersonByIndex() {
    }
}
