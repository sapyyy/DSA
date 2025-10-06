public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int n = arr.length;
        int totalZeroes = 0;
        int maxLen = 0;

        while (r < n) {
            if (arr[r] == 0) {
                totalZeroes++;
            }
        
            // shrink from the left side
            if (totalZeroes > k) {
                if (arr[l] == 0) {
                    totalZeroes--;
                }
                l++;
            }

            // if the zeroes are in the range check for the longest one
            if (totalZeroes <= k) 
                maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        
    }
}