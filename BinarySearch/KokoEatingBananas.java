package BinarySearch;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = findMax(piles);

        while (low <= high) {
            int k = (low + high)/2;

            if (findTotalHoursWhenK(piles, k) <= (long)h) {
                high = k - 1;
            }
            else {
                low = k + 1;
            }
        }

        return low;
    }

    public static long findTotalHoursWhenK(int[] arr, int k) {
        // using long as it can overflow
        long sum = 0;
        for (long ele : arr) {
            sum += (int)Math.ceil((double)ele/k);
        }

        return sum;
    }
    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int ele : arr) {
            max = Math.max(ele, max);
        }

        return max;
    }
    public static void main(String[] args) {
//        int[] arr = {3,6,7,11};
//        int[] arr = {30,11,23,4,20};
//        int[] arr = {30,11,23,4,20};
        int[] arr = {805306368,805306368,805306368};
        System.out.println(minEatingSpeed(arr, 1000000000));
    }
}
