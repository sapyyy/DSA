import java.util.*;
public class LongestSubArrWIthSumK {
    // better soln 
    public static int findSumKBetter(int[] arr, long k){
        // Store the prefixsum in the hashmap

        // in the map the key will be the prefixsum and the value will be index
        Map <Long, Integer> hashMap = new HashMap <> ();

        int maxLen = 0;
        long prefixSum = 0;

        for (int i=0; i<arr.length; i++){
            prefixSum += arr[i];

            if (prefixSum == k){
                maxLen = i+1;
            }
            else {
                long find = prefixSum - k;
                if (hashMap.containsKey(find)){
                    int count = i - hashMap.get(find);
                    maxLen = Math.max(count, maxLen);
                    // System.out.println("Count : "+count);
                }
            }
            
            if (!hashMap.containsKey(prefixSum)){
                hashMap.put(prefixSum, i);
            }
        }

    return maxLen;
    }
    // when there is only positive
    // subarray : is always consecutive
    public static int findSumK(int[] arr, int k){
        int longestCnt = 0;
        for (int i=0; i<arr.length; i++){
            int count = 0;

            // if the element is th key check if the longest array is less than 1 and store
            // if the element is less than key, then consecutively search for items until the sum is key
            if (arr[i] <= k){
                int j = i;
                int sum = 0;
                while (sum<k && j<arr.length){
                    sum += arr[j];
                    count++;
                    j++;
                }

                // store in longestCount if the count is larger
                if (sum == k){
                    if (count > longestCnt) longestCnt = count;
                }
            }
        }
        // finally return the longestCnt
        return longestCnt;
    }
    public static void main(String[] args) {
        int no = findSumK(new int[]{1,2,3,1,0,1,1}, 3);
        int no2 = findSumKBetter(new int[]{1,2,3,1,1,1,1}, 3);
        System.out.println(no);
        System.out.println(no2);
    }
}
