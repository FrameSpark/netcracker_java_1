import Person.Person;
import org.joda.time.LocalDate;

import java.util.Scanner;

class Controller {
    public void printMenu()
    {
        System.out.println("1 - Get a size");
        System.out.println("2 - Add an person");
        System.out.println("3 - Delete person by index");
        System.out.println("4 - Change an person by index");
        System.out.println("5 - Show an repository");
        System.out.println("6- Show person by index");
        System.out.println("7- Compare to age person by index");
        System.out.println("0 - Exit");
        System.out.println("Press action: ");
    }
    public void print (String text){
        System.out.println(text);
    }

    public Person create(){
        int temp;
        String tempStr;
        LocalDate tempDate;
        String tempForDate;
        int tempG;
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);

        controller.print("id:");
        temp = scanner.nextInt();
        controller.print("Fio");
        tempStr = scanner.next();
        controller.print("IsMale(0,1)");
        tempG = scanner.nextInt();
        controller.print("Date of birth yyyy-mm-dd");
        tempForDate = scanner.next();
        tempDate = new LocalDate(tempForDate);
        Person newPerson = new Person(temp,tempStr,tempG,tempDate);
        return newPerson;
    }
}
