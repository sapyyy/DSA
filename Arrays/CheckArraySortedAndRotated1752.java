public class CheckArraySortedAndRotated1752{
    public static boolean sorted(int[] arr){
        for (int i=1; i<arr.length; i++){
            if (arr[i-1] > arr[i])
                return false;
        }

        return true;
    }
    public static void main(String[] args) {
        System.out.println(sorted(new int[]{2,3,5,6,66,4,99,99}));
    }
}