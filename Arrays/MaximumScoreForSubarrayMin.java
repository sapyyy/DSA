public class MaximumScoreForSubarrayMin {
    public static int pairWithMaxSum(int nums[]) {
        int largestSum = Integer.MIN_VALUE;

        for (int i=0; i<nums.length-1; i++){
            largestSum = Math.max(largestSum,nums[i]+nums[i+1]);
        }

        return largestSum;
    }
    public static void main(String[] args) {
        System.out.println(pairWithMaxSum(new int[]{4, 3, 1, 5, 6}));
    }
}
