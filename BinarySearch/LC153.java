package BinarySearch;

public class LC153 {
    public static int findMin(int[] arr) {
        // edge case -> if there is only one element
        if (arr.length == 1) return arr[0];

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // if the array from low to high is sorted then the first element is the minimum one
            if (arr[mid] >= arr[low] && arr[mid] < arr[high]) {
                return arr[low];
            }
            // if the first element is greater than the mid-element, then the min element is in the left half
            else if (arr[mid] < arr[low]) {
                // checking if the mid-element is the min element
                if (mid > 0 && arr[mid-1] > arr[mid]) return arr[mid];

                high = mid - 1;
            }
            // if the last element is smaller than the mid-element, the min element is in the right half
            else if (arr[mid] > arr[high])  {
                low = mid + 1;
            }
            // this will only run when (low == high), i.e. we have only one element in the array
            else {
                return arr[low];
            }
        }

        // this will never run
        return -1;
    }
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3,4,5,1,2}));
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[]{11,13,15,17}));
    }
}
