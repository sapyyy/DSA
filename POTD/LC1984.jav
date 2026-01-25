public class LC1984 {
    public int minimumDifference(int[] nums, int k) {
        // 7,4,7,1,9 k = 1 -> return 0
        // 9,4,1,7 k = 3 -> 5 (1 4 5 10)
        if (k==1) return 0;

        // we want the elements to be as close as possible
        // to get the minimum max and min difference
        Arrays.sort(nums);
        int l = 0;
        int r = k - 1;
        int minDiff = 1000000;

        while (r < nums.length) {
            minDiff = Math.min(minDiff, nums[r] - nums[l]);
            r++;
            l++;
        }

        return minDiff;
    }
    public static void main (String[] args) {
        
    }
}