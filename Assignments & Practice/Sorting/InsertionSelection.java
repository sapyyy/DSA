import java.util.*;

public class InsertionSelection {
    // generic method to perform insertion sort
    public static <T extends Comparable<T>> void insertionSort(T[] arr){
        int n = arr.length;
        System.out.println("Insertion Sort : ");
        
        int i = 1;
        while (i<n){
            int j = i;
            while (j >= 1){
                // if the previous element is greater then just swap
                if (arr[j-1].compareTo(arr[j]) > 0){
                    swap(arr, j, j-1);
                }
                
                j--;
                
                // for every operation we display the array
                System.out.println(Arrays.toString(arr));
            }

            i++;
        }
    }

    // generic method to perform selection sort
    public static <I extends Comparable<I>> void selectionSort(I[] arr){
        int n = arr.length;
        System.out.println("Selection Sort : ");

        int i = 0;
        while (i < (n - 1)) {
            int min = i;
            int j = i+1;

            // store the minimum index inside the min variable
            while (j < n) {
                if (arr[min].compareTo(arr[j]) > 0) 
                    min = j;

                j++;
            }

            // now swap the current ith value with the minimum
            swap(arr,i,min);
            System.out.println(Arrays.toString(arr));

            i++;
        }
    }
    
    // swap method to swap two variables
    public static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main (String[] args) {
        insertionSort(new Integer[]{2,34,499,221,1,10});
        selectionSort(new Integer[]{2,34,499,221,1,10});
    }
}
