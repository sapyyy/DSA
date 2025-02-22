import java.util.*;

public class RemoveDuplicateArray {
    public static void main(String[] args) {
        // BruteForce
        int[] arr = {2,2,3,3,4,4,5,5,6,6,7,8,9};

        Set <Integer> set = new TreeSet <> ();

        for (int ele : arr){
            set.add(ele);
        }

        System.err.println(set);
        System.out.println(set.size());

        // Optimal 
        int i = 0;
        int n = arr.length;
        for (int j=1; j<n; j++){
            if (arr[i] != arr[j]){
                arr[++i] = arr[j];
            }
        }
        System.out.println(i+1);
        for (int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
