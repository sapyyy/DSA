package BinarySearch;

import java.util.*;

public class LC540 {
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        // binary search
        while (low <= high) {
            int mid = (low + high) / 2;

            // if the mid index is even
            if (mid % 2 == 0) {
                // if the element next to the even position is sorted,
                // then the array till mid is sorted, so single element is in the right
                if (mid < n-1 && nums[mid] == nums[mid + 1]) {
                    low = mid + 2;
                }
                // if the element before the even position is sorted
                // the single element is in the left position
                else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    high = mid - 2;
                }
                // if both the cases are not true, then the mid is the single element
                else {
                    return nums[mid];
                }
            }
            // if the mid is not even, it is odd
            else {
                // if the next position after the odd position is the same element,
                // then the single element will be at the left side
                if (mid < n-1 && nums[mid] == nums[mid + 1]) {
                    high = mid - 1;
                }
                // if the before pos is the same element then,
                // the right side will contain the single element
                else if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    low = mid + 1;
                }
                // if the both cases are false, then mid is the single element
                else {
                    return nums[mid];
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,3,4,4,8,8};
        System.out.println(singleNonDuplicate(arr));
    }
}
