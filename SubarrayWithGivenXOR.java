import java.util.*;
public class SubarrayWithGivenXOR {
    public static int subarraysWithXorK(int[] nums, int k) {
        Map <Integer, Integer> map = new HashMap <> ();
        int n = nums.length;
        int xor = 0;
        map.put(xor, 1);
        int count = 0;

        for (int i=0; i<n; i++){
            xor ^= nums[i];
            int x = xor ^ k;
            count += map.getOrDefault(x, 0);
            map.put(xor, map.getOrDefault(xor, 0)+1);
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraysWithXorK(new int[]{4,2,2,6,4}, 6));
    }
}
