package BinarySearch;

class SmallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = max(nums);

        if (nums.length > threshold) 
            return -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (totalSum(nums, mid, threshold) <= threshold) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int totalSum(int[] arr, int k, int threshold) {
        int sum = 0;

        for (int ele : arr) {
            sum += (int)Math.ceil((double)ele/k);

            if (sum > threshold) {
                return sum;
            }
        }

        return sum;
    }

    public static int max(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int ele : arr) {
            if (ele > max)
                max = ele;
        }

        return max;
    }
    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{44,22,33,11,1}, 5));
    }
}