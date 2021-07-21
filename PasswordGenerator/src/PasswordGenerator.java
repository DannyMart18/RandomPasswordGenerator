import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordGenerator {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        boolean ok = false;
        int size = 0;
        while(size != -1) {


            do {


                try {
                    System.out.println("What size of password would you like to create? \nEnter -1 to exit!");
                    size = input.nextInt();

                    if (size == -1) {
                        System.out.println("Goodbye");
                        break;
                    }


                    if (size < 1) {
                        System.out.println("Password can't be less than 1");

                    } else {
                        String password = "";

                        for (int i = 0; i < size; i++) {
                            password += randomCharacter();
                        }
                        writeFile(password);
                        printPassword(password);
                        ok = true;

                    }
                } catch (Exception e) {
                    System.out.println("Invalid selection");
                    input.nextLine();
                }

            } while (!ok);

        }

    }

    public static void printPassword(String password){
        System.out.println("Your generated password is: " + password +"\n================================");
    }

    public static void writeFile(String password){
        try {
            FileWriter fw = new FileWriter("Password.txt");
            fw.write(password);
            fw.close();
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occurred - could not write to file");
        }

    }

    //Create a function that randomly generates a letter (lowercase or uppercase) or number (0-9) using ASCII
    //'0' - '9' => 48-57 in ASCII
    //'A' - 'Z' => 65-90 in ASCII
    //'a' - 'z' => 97-122 in ASCII
    public static char randomCharacter(){
        int rand = (int)(Math.random()* 62);


        //0-61 inclusive = all possible values of rand
        //0-9 inclusive = 10 possible numbers/digits
        //10-35 inclusive = 26 possible uppercase letters
        //36-61 inclusive = 26 possible lowercase letters
        //If rand is between 0 (inclusive) and 9 (inclusive), we can say it's a number/digit
        //If rand is between 10 (inclusive) and 35 (inclusive), we can say it's an uppercase letter
        //If rand is between 36 (inclusive) and 61 (inclusive), we can say it's a lowercase letter
        if(rand < 9){
            //Number (48-57 in ASCII)
            //To convert from 0-9 to 48-57, we can add 48 to rand because 48-0 = 48
            int number = rand + 48;
            return (char)(number);
        }else if(rand <= 35){
            //Uppercase letter (65-90 in ASCII)
            //To convert from 10-35 to 65-90, we can add 55 to rand because 65-10 = 55
            int uppercase = rand + 55;
            return (char)(uppercase);
        }else{
            //Lowercase letter (97-122 in ASCII)
            //To convert from 36-61 to 97-122, we can add 61 to rand because 97-36 = 61
            int lowercase = rand + 61;
            return (char)(lowercase);
        }



    }
}
