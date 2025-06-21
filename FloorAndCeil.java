import java.util.*;
public class FloorAndCeil {
    public static int[] getFloorAndCeil(int[] nums, int x) {
        int n = nums.length;

        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] > x) {
                high = mid - 1;
            }
            else if (nums[mid] < x) {
                low = mid + 1;
            }
            else {
                return new int[]{nums[mid], nums[mid]};
            }
        }

        int firstEle = (low - 1) > 0? nums[low - 1] : -1;
        int secondEle = (low - 1) < n-1? nums[low] : -1;
        return new int[]{firstEle, secondEle};
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int x = 8;
        System.out.println(Arrays.toString(getFloorAndCeil(arr, x)));
    }
}

