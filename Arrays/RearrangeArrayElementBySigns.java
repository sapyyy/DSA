import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayElementBySigns {
    public static int[] rearrangeArray(int[] nums){
        int n = nums.length;

        // to ensure that the first element is positive
        if (nums[0] < 0){
            int j=1;
            while (j < n && j < 0) j++;
            swap(nums, j, 0);
        }
        
        // now we iterate the loop twice at a time as we know the array size is even in len
        for (int i=1; i<n; i++){
            // if the first ele is negative which is not supposed to we interchange it with a positive ele
            if (i % 2 == 0 && nums[i] < 0){
                int j = i + 1;
                while (j < n && nums[j] < 0) j++;
                swap(nums, j, i);
            }
            // and if the second ele is postivie which is not supposed to we interchange with a negative ele
            else if (i % 2 != 0 && nums[i] > 0){
                int j = i + 1;
                while (j < n && nums[j] > 0) j++;
                swap(nums, j, i);
            }
            }

            return nums;
        }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] arr = rearrangeArray(new int[]{28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31});
        for (int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
