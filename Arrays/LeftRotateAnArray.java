public class LeftRotateAnArray {
    public static void main(String[] args) {
        // Bruteforce
        int arr[] = {2,3,4,5,6,7};

        for (int i=(arr.length-1); i>0; i--){
            arr[i] = arr[i] ^ arr[i-1];
            arr[i-1] = arr[i-1] ^ arr[i];
            arr[i] = arr[i] ^ arr[i-1];
        }

        for (int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
