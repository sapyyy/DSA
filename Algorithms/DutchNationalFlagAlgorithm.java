// Given an array arr[] consisting of only 0s, 1s, and 2s. The task is to sort the array,
// i.e., put all 0s first, then all 1s and all 2s in last.

public class DutchNationalFlagAlgorithm{
    public static void algo(int[] arr){
        int n = arr.length;
        // we take 3 pointers
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while (mid <= high){
            if (arr[mid] == 0){
                swap(arr, low, mid);
                low++;
                mid++;
            }
            else if (arr[mid] == 1)
                mid++;
            else {
                swap(arr, mid, high);
                high--;
            }
        }

        for (int ele : arr){
            System.out.print(ele + " ");
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        algo(new int[]{1,1,0,1,1,0,2,0,1,2,2,2});
    }
}