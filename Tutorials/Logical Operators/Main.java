import java.util.Scanner;

//Use scanner to read lines as strings, and then build a parser to deduce type from there. If no type found then output error.

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        boolean error = false; //is there a way to catch an error and throw out at end w/out running if/elses for rest of unran code?
        double num1;
        double num2;
        char operator;
        double result = 0.0;

        System.out.print("Enter the first number: ");
        num1 = scanner.nextDouble();

        System.out.print("Enter an operator (+, -, *, /, \\ (int div), ^): ");
        operator = scanner.next().charAt(0); //by default, scanner.next() accepts a string
        //We take the 1st element of the char array (string), which gives us the 1st char the user enters


        System.out.print("Enter the second number: ");
        num2 = scanner.nextDouble();


        if(num2 == 0.0 && (operator == '/' || operator == '\\')){
            System.out.println("Cannot divide by 0!");
        }

        else{
            switch(operator){
            case '+' -> result = num1 + num2;
            case '-' -> result = num1 - num2;
            case '*' -> result = num1 * num2;
            case '/' -> result = num1 / num2;
            case '\\' -> result = (int) num1 / (int) num2;
            case '^' -> result = Math.pow(num1, num2); //Math is a default lib in Java
            default -> error = true; //something went wrong
            }
        
            switch(operator){
                case '+' -> System.out.printf(num1 + " plus " + num2 + " equals %.2f\n", result);
                case '-' -> System.out.printf(num1 + " minus " + num2 + " equals %.2f\n", result);
                case '*' -> System.out.printf(num1 + " times " + num2 + " equals %.2f\n", result);
                case '/' -> System.out.printf(num1 + " divided by " + num2 + " equals %.2f\n", result);
                case '\\' -> System.out.printf(num1 + " integer divided by " + num2 + " equals %.0f\n", result);
                case '^' -> System.out.printf(num1 + " to the power of " + num2 + " equals %.2f\n", result);
            }
        }

        if(error){
                System.out.println("Unknown mathematical operator!");
            }
        else{
            if(result == 42){
                System.out.println("Ah, the answer to everything!");
            }
            else if(result > 0){
                System.out.println("Your answer is positive!");
            }
            else if(result <= -99){
                System.out.println("Your answer is no fun!");
            }
            else if(result % 4 == 1 || result % 4 == 2){
                System.out.println("What the heck is this supposed to mean?!");
            }
            else{
                System.out.println("Wow, you passed NONE of the tests...");
            }
        }

        /*This program can handle incorrect operators,
        but cannot handle non-doubles passed in for num1 or num2*/

        scanner.close();

    }
}
