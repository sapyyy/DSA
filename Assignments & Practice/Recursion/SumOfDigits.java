package Recursion;

/*4. Write a recursive function to calculate the sum of all digits of a number entered by the user. */

import java.util.*;

public class SumOfDigits {
    public static int sumOfDigits(int num, int sum){
        if (num == 0)
            return 0;
        
        return sum + sumOfDigits(num / 10, sum + (num % 10));
    }
    public static void main (String[] args){
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        System.out.println(sumOfDigits(n, 0));
        sc.close();
    }
}
