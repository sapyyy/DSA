package Recursion;

/*2. Write a recursive function to print the first n Fibonacci numbers. */

import java.util.*;

public class NFibonacci {
    public static void NFibo(int secondlast, int last, int n){
        if (n == 0){
            return;
        }

        System.out.print(secondlast + " ");
        NFibo(last,secondlast + last, n-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the nth term to which you want your Fibonacci series : ");
        int n = sc.nextInt();

        NFibo(0,1,n);
        sc.close();
    }
}
