public class RowWithMaxOnes {
    public static int rowWithMax1s(int arr[][]) {
        int maxOnes = 0;
        int index = -1;
        for (int i=0; i<arr.length; i++) {
            int ones = findNumberOfOnes(arr[i]);

            if (ones > maxOnes) {
                maxOnes = ones;
                index = i;
            }
        }
        
        return index;
    }
    
    public static int findNumberOfOnes(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        
        if (arr[low] == 0 && arr[high] == 0) {
                return 0;
        }

        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] == 1) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        

        return (arr.length - low);
    }
    public static void main(String[] args) {
        System.out.println(rowWithMax1s(new int[][]{
            {0,1,1,1},
            {0,0,1,1},
            {1,1,1,1},
            {0,0,0,0},
            {0,0,1,1,1,1}
        }));
    }
}
