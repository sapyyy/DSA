public class BubbleSort {
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        
        for (int i=0; i<n; i++){
            // swap function helps to check whether the algorithm is already sorted or not
            boolean swap = false;
            for (int j=0; j<n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    // swapping without a third variable
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                    swap = true;
                }
            }
            if (swap == false)
                break;
        }
        
        for (int ele : arr){
            System.out.print(ele + " ");
        }
        
        System.out.println();
    }

    public static <T extends Comparable<T>> void genericBubbleSort(T[] arr){
        int n = arr.length;
        for (int i=0; i<arr.length; i++){
            boolean swap = false;
            for (int j=0; j<n-i-1; j++){
                if (arr[j].compareTo(arr[j+1])>0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    swap = true;
                }
            }
            if (swap == false)
                break;
        }
        
        for (T ele : arr)
            System.out.print(ele + " ");

        System.out.println();
    }
    public static void main(String[] args) {
        bubbleSort(new int[]{3,4,5,3,2,1,0});
        bubbleSort(new int[]{5,4,2,1,0});
        
        Integer[] arr = {7,4,4,2,3,2,1};
        String[] strArr = {"Saptadeep", "Debanjan", "Tapasi", "Swapan"};
        Double[] dArr = {23.3, 53.3, 84.2, 33.1};
        genericBubbleSort(arr);
        genericBubbleSort(strArr);
        genericBubbleSort(dArr);
    }
}
