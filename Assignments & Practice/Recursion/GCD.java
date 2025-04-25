package Recursion;

/*1. Write a recursive function to calculate the gcd of two numbers.*/

import java.util.*;

public class GCD {
    public static int findGCD(int a, int b){
        if (a == 0)
            return b;
        
        if (b > a){
            findGCD(b, a);
        }

        return findGCD(a%b, a);
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the first number : ");
        int a = sc.nextInt();
        System.out.print("Enter the second number : ");
        int b = sc.nextInt();

        System.out.println("The GCD of the two numbers are : "+findGCD(a,b));
        sc.close();
    }
}
