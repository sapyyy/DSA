public class MaximumSubArrKOptimal {
    public static int maxSubArr(int[] arr, int k){
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        int n = arr.length;
        long sum = arr[0];

        while (right < n){
            while (left <= right && sum > k){
                sum -= arr[left];
                left++;
            }

            if (sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }
            
            right++;
            if (right < n)
                sum += arr[right];
        }
        
        return maxLen;
    }
    public static void main(String[] args) {
        int maxLen = maxSubArr(new int[]{2,3,4,5,6},11);
        System.out.println(maxLen);
    }
}
