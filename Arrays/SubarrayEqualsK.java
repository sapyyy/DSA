import java.util.*;

public class SubarrayEqualsK {
    public static int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int result = 0;
        Map <Integer, Integer> map = new HashMap <> ();
        
        map.put(0, 1);
        for (int i=0; i<nums.length; i++) {
            prefixSum += nums[i];
            int diff = prefixSum - k;
            
            if (map.containsKey(diff)) {
                result += map.get(diff);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
    }
    public static void main(String[] args) {
        subarraySum(new int[]{5, 5, -5, 0, 0, 5, 5, -5}, 10);
    }
}
