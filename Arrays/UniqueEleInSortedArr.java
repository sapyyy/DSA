public class UniqueEleInSortedArr {
    public static int[] uniqueElementArr(int[] arr){
        int i = arr[0];
        int j = arr[1];

        while (j < arr.length && i < arr.length){
            // increment the j and check whether the value is still the same
            if (arr[i] == arr[j] && j < arr.length){
            j++;
            System.out.println("i : "+i+" "+"j : "+j);
            }
            else if (arr[i] != arr[j]) continue;
            // so when j contains unique elements we swap arr[j] and arr[i]
            swap(arr, ++i, j);
         }


        return arr;
    }
    public static void swap(int[] arr,int i, int j){
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[j] ^ arr[i];
        arr[i] = arr[i] ^ arr[j];
    }
    public static void main(String[] args) {
        int[] finalArr = uniqueElementArr(new int[]{1,1,1,2,2,2,2,2});
        
        for (int ele : finalArr){
            System.out.print(ele + " ");
        }
    }
}
