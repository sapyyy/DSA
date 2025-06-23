import java.util.*;

public class LC1539 {
    public static int findKthPositive(int[] arr, int k) {
        Set <Integer> hash = new HashSet <> ();
        for (int ele : arr){
            hash.add(ele);
        }

        int counter = 0;
        for (int i=1; i<arr.length+k; i++) {
            if (!hash.contains(i)) {
                counter++;
            }

            if (counter==k)
                return i;
        }

        return -1;
    }
    public static void main (String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
        
    }
}
