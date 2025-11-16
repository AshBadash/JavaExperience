import java.util.Scanner;
//Overloading methods in Java refers to creating multiple methods by the same name, that take different types / ammounts of parameters.
//Together the return type, name, and parameters create a unique method signiture.

/*Three places where variables can go: after Main, a class variable.
After static void main, a local variable, or in any other method under main, also local to its method.*/

public class Main {

    public static void main(String[] args){

        //Practice with methods

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.next();

        happyBirthday(name);

        scanner.close();
    }

    static void happyBirthday(String name){
        System.out.print("\nHappy birthday to you,\n");
        System.out.print("Happy birthday to you,\n");
        System.out.print("Happy birthday dear " + name +",\n");
        System.out.print("Happy birthday to you!!!\n\n\n");

    }
}
