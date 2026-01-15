public class CountNoOfNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int counts = 0;
        int n = nums.length;

        int finalCount = 0;
        for (int i=0; i<n; i++) {
            int count = 0;
            for (int j=0; j<=i; j++) {
                // we check and increment the total no of odd numbers in the subarray
                if (nums[j] % 2 != 0) count++;

               // when there will be exactly k numbers of total odd numbers
                if (count == k) finalCount++; 

                // finally if there is more than k numbers we skip
                if (count > k) break;
            }
        }
    }
    public static void main(String[] args) {
        
    }    
}
