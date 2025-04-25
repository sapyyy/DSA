package Recursion;

/*3. Write a recursive function to calculate the power of a two number(consider the degree as a
negative/positive integer). */

import java.util.*;

public class Power {
    public static double pow(double num, double power){
        if (power >= 0){
            // check if the power is 0 or 1
            if (power == 0)
                return 1;
            else if (power == 1)
                return num;
                
            return pow(num, power-1) * pow(num, 1);
        }
        else {
            // for negative degree we perform other operation
        if (power == 0)
        return 1;
        else if (power == -1)
        return 1/num;
    
        return pow(num , power+1) * pow(num, -1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the number : ");
        double n = sc.nextInt();
        System.out.print("Enter the power : ");
        double pow = sc.nextInt();

        System.out.println(pow(n, pow));
        sc.close();
    }
}