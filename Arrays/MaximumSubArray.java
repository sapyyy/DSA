public class MaximumSubArray {
    public static int maxSubArray(int[] nums) {
      int largestSum = Integer.MIN_VALUE;

      int sum = 0;

      for (int i=0; i<nums.length; i++){
        sum += nums[i];
        
        largestSum = Math.max(largestSum, sum);

        if (sum < 0)
            sum = 0;
      }

      return largestSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{5,4,-1,7,8}));
    }
}
