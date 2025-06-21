public class LowerBound {
    public static int lowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int lowerBound = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
                lowerBound = mid;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }

        return lowerBound;
    }
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1,3,6,8,8,8,8,9}, 2));
    }
}
