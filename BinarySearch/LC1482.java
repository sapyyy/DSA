package BinarySearch;

public class LC1482 {
    public static int minDays(int[] bloomDay, int m, int k) {
        // impossible case when the m x k > n
        if ((long)m * k> bloomDay.length) {
            return -1;
        }

        int low = findMin(bloomDay);
        int high = findMax(bloomDay);

        while (low <= high) {
            int mid = (low + high) / 2;

            if (findBouquetsWhenMid(bloomDay, k, mid) >= m) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;

        for (int ele : arr) {
            min = Math.min(min, ele);
        }

        return min;
    }

    public static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int ele : arr) {
            max = Math.max(max, ele);
        }

        return max;
    }

    public static int findBouquetsWhenMid(int[] arr, int k, int mid) {
        int bouquets = 0;
        int adjacent = 0;

        for (int ele : arr) {
            if (ele <= mid)
                adjacent++;
            else {
                bouquets += (adjacent/k);
                adjacent = 0;
            }
        }


        bouquets += (adjacent/k);

        return bouquets;
    }
        public static void main(String[] args) {
            System.out.println(minDays(new int[]{1,10,3,10,2},3, 2));
    }
}
