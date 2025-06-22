public class UpperBound {
    public static int upperBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                while (nums[mid] == target) mid++;
                return mid;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        System.out.println(upperBound(new int[]{1,3,5,7}, 1));
    }
}
