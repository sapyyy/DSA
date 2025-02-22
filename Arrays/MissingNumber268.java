public class MissingNumber268 {
    public static int missingNumber(int[] nums) {
        int len = nums.length;

        // calculate the sum of the elements which are there in the array
        int diff = 0;
        for (int i=0; i<len; i++){
            diff += nums[i];
        }

        // finally return the difference
        return ((len * (len + 1)) / 2) - diff;
    }
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,1,4,3,2}));
    }
}
