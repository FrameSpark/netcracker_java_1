import Person.Controller;
import Person.Repository;
import org.joda.time.LocalDate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        Repository repos = new Repository(0);
        boolean run = true;
        int select =0;
        int temp;
        while (run){
            controller.printMenu();
            select=scanner.nextInt();


            switch(select){
                case 1:
                    controller.print("Size of array: ");
                    controller.print(String.valueOf(repos.getSize()));
                    break;
                case 2:
                    controller.print("Adding an person:");
                    repos.insertPerson(controller.create());
                    controller.print("\nArray: ");
                    repos.showArray();
                    controller.print("\n");
                    break;
                case 3:
                    controller.print("Deleting an element");
                    controller.print("Index: ");
                    temp = scanner.nextInt();
                    repos.deletePersonByIndex(temp);
                    controller.print("\nArray: ");
                    repos.showArray();
                    controller.print("\n");
                    break;
                case 4:
                    controller.print("Changing an element:");

                    controller.print("Index: ");
                    temp = scanner.nextInt();

                    controller.print("New person: ");

                    repos.changePersonByIndex(controller.create(),temp);

                    controller.print("\nArray: ");
                    repos.showArray();
                    controller.print("\n");
                    break;
                case 5:
                    controller.print("\nArray: ");
                    repos.showArray();
                    controller.print("\n");
                    break;
                case 6:
                    controller.print("\nEnter the element: ");
                    temp = scanner.nextInt();
                    controller.print("\n");
                    repos.showPersonByIndex(temp);

                    break;
                case 0:
                    run = false;
                    break;
                default:
                    controller.print("There is no such function \n");
            }
        }

    }
}