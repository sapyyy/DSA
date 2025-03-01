public class ApplyOperationsToAnArray {
    public static int[] applyOperations(int[] arr){
        int n = arr.length;

        // perform the operation here
        for (int i=0; i<n-1; i++){
            if (arr[i] == arr[i+1] && arr[i] != 0){
                arr[i] *= 2;
                arr[i+1] = 0;
            }
        }


        int index = 0;
        for (int ele : arr){
            if (ele != 0){
                arr[index++] = ele;
            }
        }

        while (index < n){
            arr[index++] = 0;
        }

        return arr;
    }
    public static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
    }
    public static void main(String[] args) {
        int [] arr = {847,847,0,0,0,399,416,416,879,879,206,206,206,272};
        int [] arr2 = {1,2,2,1,1,0};
        int[] arrNew = applyOperations(arr);

        for (int ele : arrNew){
            System.out.print(ele + " ");
        }
    }
}
