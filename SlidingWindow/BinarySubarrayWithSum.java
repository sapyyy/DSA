public class BinarySubarrayWithSum {
    public int findSubarray(int[] arr, int goal) {
        int l = 0;
        int r = 0;
        int n = arr.length;
        long sum = 0;
        int totalSub = 0;

        while (r < n) {
            sum += arr[r];

            while (sum > goal && l <= r) {
                sum -= arr[l];
                l++;
            }

            totalSub += (r - l + 1);
            r++;
        }

        return totalSub;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return findSubarray(nums, goal) - findSubarray(nums, goal - 1);
    }
    public static void main(String[] args) {
        
    }
}
