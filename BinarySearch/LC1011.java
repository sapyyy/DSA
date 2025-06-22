package BinarySearch;

public class LC1011 {
    public static int shipWithinDays(int[] weights, int days) {
        int low = 1;
        int high = totalSum(weights);

        while (low <= high) {
            int mid = (low + high)/2;

            if (findMinDays(weights, mid, days) <= days) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public static int findMinDays(int[] arr, int weight, int days) {
        int resultDays = 0;
        int curWeight = 0;

        for (int ele : arr) {
            curWeight += ele;

            if (curWeight == weight) {
                resultDays++;
                curWeight = 0;
            }
            else if (curWeight > weight) {
                resultDays++;
                curWeight = ele;
            }

            if (resultDays > days) {
                return resultDays;
            }

            // if the weight of the element is greater than the ship's weight
            // we need to increase the weight
            if (ele > weight) {
                return days + 1;
            }
        }

        if (curWeight > 0) {
            resultDays++;
        }

        return resultDays;
    }

    public static int totalSum(int[] arr) {
        int sum = 0;
        for (int ele : arr) {
            sum += ele;
        }
        return sum;
    }
    public static void main (String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(shipWithinDays(weights,  5));
    }
}
