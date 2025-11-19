import java.util.Scanner;






public class main {


    public static void main(String[] args){





        //MAD LIBS GAME





        Scanner scanner = new Scanner(System.in);








        System.out.print("Choose an adj: ");


        String adj1 = scanner.nextLine();


        System.out.print("Choose an adj: ");


        String adj2 = scanner.nextLine();


        System.out.print("Choose an adj: ");


        String adj3 = scanner.nextLine();





        System.out.print("Choose a verb: ");


        String verb1 = scanner.nextLine();


        System.out.print("Choose a verb: ");


        String verb2 = scanner.nextLine();


        System.out.print("Choose a verb: ");


        String verb3 = scanner.nextLine();





        System.out.print("Choose a noun: ");


        String noun1 = scanner.nextLine();


        System.out.print("Choose a noun: ");


        String noun2 = scanner.nextLine();


        System.out.print("Choose a noun: ");


        String noun3 = scanner.nextLine();








        //Add logic to make a-> some or a-> an





        System.out.println("\nOne quiet day, a " + adj1 + " raccoon named " + noun1 + " crept into the local hotel to steal a jar of " + noun2 + ".");


        System.out.println("Armed with only a " + adj2 + " " + noun3 + " and a DREAM, it " + verb1 + " past the security gaurd, dodged a " + verb2 + " alarm,");


        System.out.println("and " + verb3 + " into the wilderness, with the goods securred!");


        System.out.println("But just as it opened the jar... there was a " + adj3 + " mouse inside. OH NO!\n\n");








        scanner.close();


    }


}