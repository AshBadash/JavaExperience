import java.util.Scanner;

//Want to add commas to output + refactor with more helper functions.

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        boolean error = false; //is there a way to catch an error and throw out at end w/out running if/elses for rest of unran code?
        double num1;
        double num2;
        char operator;
        double result = 0.0;

        System.out.print("Enter the first number: ");
        String str1 = scanner.next();
        if(scanIsNum(str1)){
            num1 = toDouble(str1);
        }
        else{
            scanner.close();
            return;
        }

        System.out.print("Enter an operator (+, -, *, /, \\ (int div), ^): ");
        operator = scanner.next().charAt(0); //by default, scanner.next() accepts a string
        //We take the 1st element of the char array (string), which gives us the 1st char the user enters


        System.out.print("Enter the second number: ");
        String str2 = scanner.next();
        if(scanIsNum(str2)){
            num2 = toDouble(str2);
        }
        else{
            return;
        }


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
        in addition to nans!*/

        scanner.close();
    }

    //Helper methods:

    static boolean scanIsNum(String line){ // Type will be a double, need only to see if valid number or not.
        Character[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
        int decimalCount = 0;

        for(int i = 0; i < line.length(); i++){
            Character c = line.charAt(i);
            if(c == '-' && i == 0){
                continue;
            }
            
            //Check if the character is a letter (invalid), and error out immediately.
            if(Character.isLetter(c)){
                System.out.println("Invalid non-number selected!\n");
                return false;
            }

            //Check if the character is not nonsenese such as :, &, *, (, and if so error out immediately.
            else{
                boolean isSpecial = false;
                for(int j = 0; j < nums.length; j++){
                    if(c != nums[j] && c != '.' && c != ','){

                        //might just not be the CURRENT number in the array.
                        isSpecial = true;
                    }
                    else{
                        isSpecial = false;
                        break;
                    }
                }
                if(isSpecial){
                    System.out.println("Invalid non-number selected!\n");
                    return false;
                }
            }

            //Check if too many periods
            if(c == '.'){
                if(decimalCount < 1){
                    decimalCount += 1;
                }
                else{
                    System.out.println("Invalid non-number selected!\n");
                    return false;
                }
            }

            //Check periodicidy of commas
            if(c == ','){

                // Invalid comma positions
                String lastThree = line.substring(line.length() - 3, line.length());
                if(i == 0){ //i = -2, -3, -4 do not work in Java...
                    //How do I check if the last three chars are numbers... take substr from len - 4 to len -1, and examine!
                    System.out.println("Invalid non-number selected!\n");
                    return false;
                }
                for(int d = 0; d < 3; d++){
                    if(lastThree.charAt(d) == ','){
                        System.out.println("Invalid non-number selected!\n");
                        return false;
                    }
                }

                //Comma spacing
                int pos = i;
                while(pos + 4 < line.length()){
                    if(c == line.charAt(pos + 4)){ //Doesn't catch repeated commas!
                        pos += 4;
                    }
                    else{
                        System.out.println("Invalid non-number selected!\n");
                        return false;
                    }
                }
            }    
        }

        //if every case passed, this is a (valid) number!
        return true;
    }

    static double toDouble(String str){
        boolean negative = false;

        str = str.replace(",", "");
        if(str.charAt(0) == '-'){
            negative = true;
            str = str.replace("-", "");
        }
        double dub = 0.0;
        int len = str.length();

        for(int i = 0; i < len; i++){
            int digit = (str.charAt(i) - '0'); //negative sign should be handled before this point to avoid undefined behaviour
            int power = len - i - 1;
            dub += digit * Math.pow(10, power);
        }

        if(negative){
            dub *= -1;
        }
        return dub;
    }
}
