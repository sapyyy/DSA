import java.util.*;

public class SubArraySumEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int prefix = 0;
        int count = 0;
        Map <Integer, Integer> hashMap = new HashMap <> ();

        hashMap.put(0,1);
        for (int i=0; i<nums.length; i++) {
            // finding the prefix sum everytime 
            prefix += nums[i];
            int diff = prefix - k;
            count += hashMap.getOrDefault(diff, 0);
            hashMap.put(prefix, hashMap.getOrDefault(prefix,0)+1);
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{1,-1,0}, 0));
    }
}
