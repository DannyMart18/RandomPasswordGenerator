import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordGenerator {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("What size of password would you like to create?");
        int size = input.nextInt();

        String password = "";

        for (int i = 0; i < size; i++){
            password += randomCharacter();
        }
        writeFile(password);
        printPassword(password);


    }

    public static void printPassword(String password){
        System.out.println(password);
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

    public static char randomCharacter(){
        int rand = (int)(Math.random()* 62);

        if(rand < 9){
            int number = rand + 48;
            return (char)(number);
        }else if(rand <= 35){
            int uppercase = rand + 55;
            return (char)(uppercase);
        }else{
            int lowercase = rand + 61;
            return (char)(lowercase);
        }



    }
}
