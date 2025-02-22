public class MoveZeroes283 {
    public static void moveZeroes(int[] nums){
        // i variable to find the positon of the zero values
        int i = 0;
        int len = nums.length;
        // findZero function returns the zeroth postion in the array
        i = findZeroes(nums, i);
        
        // occurs when the array has not got any zero values
        if (i == len - 1) return;
        
        // Now we find the non-zero values through j and swap
        for (int j=0; j < len; j++){
            if (nums[j] != 0 && i < j){
                // swap logic
                int temp = nums[j];
                nums[j] = 0;
                nums[i] = temp;

                // find the next zeroth position
                i++;
            }
        }

        for (int ele : nums){
            System.out.print(ele + " ");
        }
    }

    public static int findZeroes(int[] nums, int i){
        while (i < nums.length - 1 && nums[i] != 0) i++;
        return i; 
    }
    public static void main(String[] args) {
        moveZeroes(new int[]{1,0,0,3,4,45,3,3,45,6,7,0,6,9,0,56,9,0});
    }
}