import java.util.Scanner;

public class Vowels {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            String vowels = "aeiouAEIOU";
            System.out.print("Type a character to check if it is a string or not : ");
            char c = sc.nextLine().charAt(0);
            if (vowels.contains(Character.toString(c))){
            System.out.println("Vowel!");
            }
            else System.out.println("Consonant!");
        }
    }
}
