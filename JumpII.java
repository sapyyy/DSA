public class JumpII {
     public static int jump(int[] nums) {
        return findMin(nums, 0, 0, Integer.MAX_VALUE, nums.length);
    }
    public static int findMin(int[] nums, int index, int count, int minCount, int n) {
        if (index >= n-1) {
            return Math.min(minCount, count);
        }
        
        for (int i=index+1; i<=index + nums[index] && i <= n-1; i++) {
            minCount = Math.min(minCount, findMin(nums, i, count+1,  minCount, n));
        }
        
        return minCount;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(jump(arr));;
    }
}