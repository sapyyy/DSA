/*6. Write a Program to implement Binary Search using a recursive function. */

public class BinarySearch {
    public static int binarySearch(int[] arr,int l, int r, int key){
        // when the l is greater than right we stop
        if (l > r)
            return -1;

        // finding the mid here
        int mid = (l + r) / 2;
        
        // search and compare to the array
        if (arr[mid] == key){
            return mid;
        }
        else if (arr[mid] > key)
            return binarySearch(arr, l, mid - 1, key);
        else
            return binarySearch(arr, mid + 1, r, key);
    }
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2,3,5,67,100}, 0, 5, 100));
    }
}
