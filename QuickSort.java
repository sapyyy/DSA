public class QuickSort {
    public static int[] quickSort(int[] arr,int low, int high){
        // stop when the low hits high or beyond
        if (low < high){
            // findPartition to find the index of the pivot element
           int partition = findPartition(arr, low, high);
           quickSort(arr, low, partition - 1);
           quickSort(arr, partition + 1, high);
        }

        return arr;
    }

    public static int findPartition(int[] arr, int low, int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        // we find the original position of the pivot element here
        while (i < j){
            // increment until there is smaller element in arr[i] and the i is also less than high
            while (arr[i] <= pivot && i < high) i++;

            // decrement until there is bigger element in arr[j] and the j is also bigger than low
            while (arr[j] > pivot && j > low) j--;

            // if i is still less than j we swap the values of arr[i] and arr[j]
            if (i < j) {
                arr[i] = arr[i] ^ arr[j];
                arr[j] = arr[j] ^ arr[i];
                arr[i] = arr[i] ^ arr[j];
            }
        }

        // as after this we are sure that j > i, we swap arr[pivot] and arr[j]
        arr[low] = arr[low] ^ arr[j];
        arr[j] = arr[j] ^ arr[low];;
        arr[low] = arr[low] ^ arr[j];


        // return the actual position of the pivot element
        return j;
    }

    public static void main(String[] args) {
        int[] arrInp = {2,3,4,5,6,2,1};

        arrInp = quickSort(arrInp, 0, arrInp.length-1);

        for (int ele : arrInp){
            System.out.print(ele + " ");
        }
    }
}
