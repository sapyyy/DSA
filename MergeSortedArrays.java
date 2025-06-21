import java.util.*;

public class MergeSortedArrays {
    // brute force
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;

        while (i<m){
            // break from the loop if it contains 0
            if (n == 0) break;
            // we only perform swap when the nums2 has smaller values than nums1
            if (nums1[i] > nums2[j]) {
                // swap the variables
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;

                // and then sort the array
                sort(nums2, j, n);
            }
            // increment the value irrespective of the condition
            i++;
        }

        // lastly the nums2 will contain elements which are sorted
        while (j<n){
            nums1[i] = nums2[j];
            i++;
            j++;
        }

        System.out.println(Arrays.toString(nums1));
    }
    public static void sort(int[] arr,int j,int n) {
        for (int i=j; i<n-1; i++) {
            if (arr[i]<=arr[i+1]) {
                return;
            }
            else {
                // swap
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
    }

    // optimal-approach
    public static void mergeOptimal (int[] nums1, int m, int[] nums2, int n) {
        // intuition : instead of starting from the beginning we start from the end
        // check for greater elements and replace the last zeroes with the greater ones
        // (merge sort logic but backwards)
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = nums1.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p3] = nums1[p1];
                p1--;
            }
            else {
                nums1[p3] = nums2[p2];
                p2--;
            }
            p3--;
        }

        while (p1 >= 0) {
            nums1[p3] = nums1[p1];
            p3--;
            p1--;
        }

        while (p2 >= 0) {
            nums1[p3] = nums2[p2];
            p3--;
            p2--;
        }

        System.out.println(Arrays.toString(nums1));
    }

    public static void main (String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        int[] nums1 = {1};
//        int[] nums2 = {};

        merge(nums1, 3, nums2, 3);
        mergeOptimal(nums1, 3, nums2, 3);
    }
}
