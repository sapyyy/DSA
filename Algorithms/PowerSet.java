import java.util.*;

public class PowerSet {
    public static List<List<Integer>> generateSubSets(int[] arr) {
        int n = arr.length;
        List <List<Integer>> result = new ArrayList <> ();

        // total subsets will be 2^n - 1
        for (int i = 0; i<=Math.pow(2, n) - 1; i++) {
            List <Integer> temp = new ArrayList <> ();
            
            // for every number we try to check which are the one bits
            for (int j = 0; j<=n-1; j++) {

                // this checks whether the bit is 1
                if ((i&(1 << j)) > 0) {
                    // add to the temp if it is the case
                    temp.add(arr[j]);
                }
            }

            // finally add the temp into result
            result.add(temp);
        }

        return result;
    }
   public static void main(String[] args) {
        System.out.println(generateSubSets(new int[]{1,2,3,4,5}));
   } 
}
