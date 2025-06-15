package BinarySearch;

import java.util.*;

public class LC33 {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        // a modified binary search here
        while (low <= high) {
            int mid = (low + high) / 2;

            // if the mid element is the target we return the mid
            if (nums[mid] == target)
                return mid;
            // else we try to find the sorted array
            else if (nums[low] <= nums[mid]) {
                // if this is the case then the left side is sorted
                // we try to check if the element is in left or right side
                if (nums[low] <= target && target < nums[mid]) {
                    // the element is in left side
                    high = mid - 1;
                }
                else {
                    // the element is in the right side
                    low = mid + 1;
                }
            }
            // this part will only execute when the right side is sorted
            else {
                if (nums[high] >= target && target > nums[mid]) {
                  // this executes when the element is in the right side
                    low = mid + 1;
                }
                else {
                    // this executes when the element is in the left side
                    high = mid - 1;
                }
            }
        }

        return -1;
    }
    public static void main (String[] args) {
        int[] nums = {3,1};
        int target = 1;

        System.out.println(search(nums, target));
    }
}
