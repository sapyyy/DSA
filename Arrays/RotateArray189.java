public class RotateArray189 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int k = 3;
        int len = nums.length;

        // copying the elements which are to be placed at the beginning
        int[] kArr = new int[k];
        for (int i = 0; i < k; i++){
            kArr[i] = nums[len - k + i];
        }

        // shifting all the elements by k and upto len - k
        for (int i=len-1; i >= k; i--){
            nums[i] = nums[i-k];
        }
        
        // then appending the copied element in it
        for (int i = 0; i < k; i++){
            nums[i] = kArr[i];
        }

        for (int ele : nums){
            System.out.print(ele + " ");
        }
        System.out.println();

        for (int ele : kArr){
            System.out.print(ele + " ");
        }
    }
}