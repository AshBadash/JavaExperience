import java.util.Scanner;
import java.math.BigDecimal;

/*FUTURE ADDITIONS:

Round to two decimal places instead of truncate.
Accept scientific notation input
Accept scientific notation output
Output less than two decimal places if not required*/ 

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
            scanner.close();
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

            if(Double.toString(result).indexOf("E") > -1){
                System.out.print("ERR. Too Large!\n");
                scanner.close();
                return;
            }
        
            //need a result with commas and two decimal places always.
            switch(operator){
                case '+' -> System.out.printf(str1 + " plus " + str2 + " equals " + toStr(result) + '\n');
                case '-' -> System.out.printf(str1 + " minus " + str2 + " equals " + toStr(result) + '\n');
                case '*' -> System.out.printf(str1 + " times " + str2 + " equals " + toStr(result) + '\n');
                case '/' -> System.out.printf(str1 + " divided by " + str2 + " equals " + toStr(result) + '\n');
                case '\\' -> System.out.printf(str1 + " integer divided by " + str2 + " equals ", toStr(result) + '\n');
                case '^' -> System.out.printf(str1 + " to the power of " + str2 + " equals " + toStr(result) + '\n');
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
                System.out.println("Invalid non-number selected! (letters)\n");
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
                    System.out.println("Invalid non-number selected! (special chars)\n");
                    return false;
                }
            }

            //Check if too many periods
            if(c == '.'){
                if(decimalCount < 1){
                    decimalCount += 1;
                }
                else{
                    System.out.println("Invalid non-number selected! (decimal count)\n");
                    return false;
                }
            }

            //Check periodicidy of commas
            if(c == ','){

                // Invalid comma positions
                String lastThree = line.substring(line.length() - 3, line.length());
                if(i == 0){ //i = -2, -3, -4 do not work in Java...
                    //How do I check if the last three chars are numbers... take substr from len - 4 to len -1, and examine!
                    System.out.println("Invalid non-number selected! (comma at end)\n");
                    return false;
                }
                for(int d = 0; d < 3; d++){
                    if(lastThree.charAt(d) == ','){
                        System.out.println("Invalid non-number selected! (comma at last three)\n");
                        return false;
                    }
                }

                //Comma spacing
                int start = i;
                int nextPos = start + 1;

                while(nextPos < line.length()){

                    if(line.charAt(nextPos) == c){
                        if((nextPos - start) % 4 != 0){
                            System.out.println("Invalid non-number selected! (comma spacing)\n");
                            return false;
                        }
                    }

                    nextPos++;
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

        int stop;
        if(str.indexOf(".") > -1){
            stop = str.indexOf(".");
        }
        else{
            stop = len;
        }

        for(int i = 0; i < stop; i++){
            int digit = (str.charAt(i) - '0'); //negative sign should be handled before this point to avoid undefined behaviour
            int power = (stop - 1) - i;
            dub += digit * Math.pow(10, power);
            System.out.println("dub is currently: " + dub);
        }

        for(int i = stop + 1; i < len; i++){
            int digit = (str.charAt(i) - '0');
            System.out.println("decimal digit is: " + digit + '\n');
            int power = -1 * (i - stop);
            System.out.println("decimal power is: " + power + '\n');
            dub += digit * Math.pow(10, power);
        }

        if(negative){
            dub *= -1;
        }
        
        System.out.println("String to double yields number for " + str + " of " + dub);
        return dub;
    }

    static String toStr(double result){
        System.out.println("The input double to string is: " + result + '\n');

        String answer = "";

        if(result < 0.0){
            answer += "-";
            result *= -1;
        }
        
        String digits = Double.toString(result);
        //System.out.println(digits);
        String commaPart = digits.substring(0, digits.indexOf("."));
        String decimalPart = digits.substring(digits.indexOf("."));
        

        int len = commaPart.length();
        int location;
        for(int i = 0; i < commaPart.length(); i++){
            answer += commaPart.charAt(i);
            location = len - i - 1;
            if(location != 0 && location % 3 == 0){
                answer += ","; //commas should be determined by decrementing in reverse.
            }

            location += 1;
        }

        if(decimalPart.length() < 2){
            decimalPart += "00";
        }
        else if(decimalPart.length() < 3){
            decimalPart += "0";
        }
        else{
            decimalPart = decimalPart.substring(0, 3);
        }
        answer += decimalPart;

        return answer;
    }
}
