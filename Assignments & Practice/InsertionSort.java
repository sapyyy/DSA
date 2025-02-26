public class InsertionSort {
    public static void insertionSort(int[] arr){
        int n = arr.length;

        for (int i=1; i<n; i++){
            int j = i;

            while (j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;                
                j--;
            }
        }

        for (int ele : arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    public static <T extends Comparable<T>> void genericInsertionSort(T[] arr){
        int n = arr.length;

        for (int i=0; i<n; i++){
            int j = i;
            
            while (j > 0 && arr[j - 1].compareTo(arr[j])>0){
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }

        for (T ele : arr){
            System.out.print(ele + " ");
        }
    }
    public static void main (String[] args){
        insertionSort(new int[]{4,3,22,56,111});

        String[] names = {"Saptadeep", "Debanjan", "Tapasi", "Swapan", "Arunabha"};
        genericInsertionSort(names);
    }    
}
