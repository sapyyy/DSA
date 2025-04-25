import java.util.*;

/*7. Write a Program to reverse an array using a recursive function. */

public class ReverseArray {
    public static void reverseArray(int[] arr, int l, int r){
        // we take to pointer to reverse the array
        // base condition is when the l==r, we know the array is reversed
        if (l == r)
            return;
        
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

        // increasing the front pointer and decreasing the right pointer until the base conditions matches
        reverseArray(arr, l + 1, r - 1);
    }
    public static void main (String[] args){
        int[] arr = {2,3,4,56,6};
        System.out.println("The array before reversing : "+Arrays.toString(arr));
        reverseArray(arr, 0, arr.length-1);
        System.out.println("The array after reversing : "+Arrays.toString(arr));
    }
}
