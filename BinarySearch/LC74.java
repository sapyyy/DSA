public class LC74 {
    // optimal soln 1 
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[mid][0] == target) {
                return true;
            }
            else if (matrix[mid][0] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }


        System.out.println(high);
        if (high >= 0) {
            return binarySearch(matrix[high], target);
        }

        return false;
    }

    public boolean binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        
        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                return true;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        
        return false;
    }

    // optimal 2
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int r = mid / n;
            int c = mid % n;

            if (matrix[r][c] == target) {
                return true;
            }
            else if (matrix[r][c] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return false;
    }
    public static void main (String[] args) {
        
    }
}
