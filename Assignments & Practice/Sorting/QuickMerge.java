import java.util.*;

public class QuickMerge {
    // quicksort method 
    public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high){
        if (low < high) {
            int partitionIndx = partition(arr, low, high);
            quickSort(arr, low, partitionIndx - 1);
            quickSort(arr, partitionIndx + 1, high);
        }

        System.out.println(Arrays.toString(arr));
    }

    // partition used by the quick sort method
    public static <T extends Comparable<T>> int partition(T[] arr, int low, int high){
        // selecting the pivot here 
        T pivot = arr[low];
        int i = low + 1;
        int j = high;

        while (i < j) {
            // find a value that is greater than pivot
            while (arr[i].compareTo(pivot) <= 0) {
                i++;
            }

            // find a value that is lower than the pivot
            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }

            // if i is still less than j, then we swap the values of i and j
            if (i < j) swap(arr, i, j);
        }

        // finally swap to the real position of the pivot
        swap(arr, low, j);

        // return the location of the pivot
        return j;
    }

    // method to perform mergeSort
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int low, int high){
        if (low >= high)
            return;

        int mid = (low + high) / 2;

        mergeSort(arr, low, mid - 1);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

        System.out.println(Arrays.toString(arr));
    }

    // merge method to merge two values
    public static <T extends Comparable<T>> void merge(T[] arr, int low, int mid, int high) {
        List <T> k = new ArrayList <> ();
        int i = low;
        int j = mid + 1;

        while (i <= mid && j <= high) {
            if (arr[i].compareTo(arr[j]) <= 0) {
                k.add(arr[i]);
                i++;
            }
            else {
                k.add(arr[j]);
                j++;
            }
        }

        while (i <= mid) {
            k.add(arr[i]);
            i++;
        }

        while (j <= high) {
            k.add(arr[j]);
            j++;
        }

        for (int f=low; f<high; f++) {
            arr[f] = k.get(f - low);
        }
    }

    // swap method to swap two variables
    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main (String[] args) {
        quickSort(new Integer[]{15,88,33,22,10}, 0, 4);
        quickSort(new Integer[]{15,88,33,22,10}, 0, 4);
    }
}