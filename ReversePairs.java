import java.util.*;

public class ReversePairs {
    // wrong try
    public static int reversePairs(int[] nums) {
        int totalPairs = 0;
        Arrays.sort(nums);
        int n = nums.length;

        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n; j++){
                if (nums[i] > 2*nums[j]) {
                    totalPairs++;
                }
                break;
            }
        }

        return totalPairs;
    }
    public static void main(String[] args) {
//        int[] test = {1,3,2,3,1};
        int[] test = {2,4,3,5,1};

        System.out.println(reversePairs(test));
    }
}
