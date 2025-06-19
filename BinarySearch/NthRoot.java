package BinarySearch;

public class NthRoot {
    public static int findNthRoot(int n, int m) {
        int low = 0;
        int high = m;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (m == Math.pow(mid, n)) {
                return mid;
            }
            else if (Math.pow(mid, n) < m){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return Math.pow(high, n) == m ? high : -1;
    }
    public static void main(String[] args) {
        System.out.println(findNthRoot(3, 27));
        System.out.println(findNthRoot(4, 69));
    }
}
