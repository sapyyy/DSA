import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrefixSumSubarray {
    public static void prefixSumSubarray(int[] arr, int k){
        Map <Integer, Integer> prefix = new HashMap<>();

        // maximum subarray length
        int maxLen = 0;
        int sum = 0;
        
        for (int i=0; i<arr.length; i++){
            // calculating the sum
            sum += arr[i];
            
            if (sum == k){
                // i + 1 as 0 base indexing
                maxLen = Math.max(maxLen, i+1);
            }

            // the remaining part 
            int diff = sum - k;

            // check whether it is present or not
            if (prefix.containsKey(diff)){
                int key = prefix.get(diff);
                int subLen = prefix.get(sum) - key;
                
                maxLen = Math.max(maxLen, subLen);
            }
        }

        System.out.println(maxLen);
    }
    public static void main(String[] args) {
        prefixSumSubarray(new int[]{5}, 5);
    }
}
