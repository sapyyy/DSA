import java.util.*;
public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        int maxCash1 = 0;
        int maxCash2 = 0;

        for (int i=0; i<n; i+=2) {
            maxCash1 += nums[i];
        }
        for (int i=1; i<n; i+=2) {
            maxCash2 += nums[i];
        }

        return Math.max(maxCash1, maxCash2);
    }
    public static void main (String[] args) {
//        int[] test = {1,2,3,1};
        int[] test = {2,7,9,3,1};
        System.out.println(rob(test));
    }
}
