package Sorting;

import java.util.*;

public class MergeSort {
    public static void mergeSort(int[] arr, int low, int high) {
        // if the low is high then there is only one element
        if (low >= high) {
            return;
        }

        int mid = (low + high) / 2;
        // split into two halves until low is high
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);

        // and merge here, that will help to join both the arrays
        merge(arr, low, mid, high);
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int[] finalArr = new int[high - low + 1];

        int i=0;
        while (left <= mid && right <= high){
            if (arr[left] < arr[right]){
                finalArr[i++] = arr[left++];
            }
            else if (arr[left] >= arr[right]) {
                finalArr[i++] = arr[right++];
            }
        }

        while (left <= mid) {
            finalArr[i++] = arr[left++];
        }

        while (right <= high) {
            finalArr[i++] = arr[right++];
        }

        for (int k=low; k <= high; k++) {
            arr[k] = finalArr[k - low];
        }
    }
    public static void main (String[] args) {
        int[] demo = new int[]{2,3,55,1,98,0};
        mergeSort(demo, 0, demo.length-1);
        System.out.println(Arrays.toString(demo));
    }
}
