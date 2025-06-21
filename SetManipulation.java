import java.util.*;
import java.util.stream.Collectors;

public class SetManipulation {
    public static void main (String[] args) {
        Set <List<Integer>> set = new HashSet <> ();
        ArrayList <Integer> arr = new ArrayList <> ();

        // adding elements to the array and then to the set
        arr.add(54);
        arr.add(5);
        arr.add(54);

        set.add(arr);
        set.add(arr);

        System.out.println(set);

        // converting the set to list
        List <List<Integer>> finalArr = new ArrayList <> ();
        finalArr = new ArrayList<>(set);
        System.out.println(finalArr);

        int[] arr1 = {34,3,43,443,44,-1,-2,38,-3,48,84,4};
        System.out.println(arr1.length);

        int sum = 0;
        int product = 1;
        for (int ele : arr1) {
            if (ele%6==0){
                sum += ele;
                System.out.println("The element is divisible by 6 : "+ele);
            }

            if (ele<0){
                product *= ele;
                System.out.println("The element is less than 0 : "+ele);
            }
        }


        System.out.println("The sum : "+sum);
        System.out.println("The product : "+product);

        // storing a number into the num variable
        int num = 5939004;

        // using for loop to divide and get the quotient inside i every time until it reaches 0
        for (int i=num; i!=0; i=i/10){
            // then getting the last digit of i in d everytime
            int d = i%10;
            // printing the d everytime
            System.out.print(d + " ");
        }
    }
}
