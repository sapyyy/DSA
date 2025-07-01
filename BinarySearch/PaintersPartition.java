public class PaintersPartition {
    public static int paint(int A, int B, int[] C) {
        int low = -1; // contains the max element
        int high = 0; // contains the total sum
        final int mod = 10000003;

        
        for (int i=0; i<C.length; i++) {
            low = Math.max(low, C[i]);
            high = high + C[i];
        }

        if (A >= C.length) return low;
        if (A == 1) return high;
        
        while (low <= high) {
            int mid = (low+high) / 2;

            if (paintersAllocated(C, mid, A) <= A) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return (low*B)%mod;
    }

    public static int paintersAllocated(int[] arr, int mid, int painters) {
        int totalPainters = 0;
        int timeTaken = 0;

        for (int i=0; i<arr.length; i++) {
            timeTaken += arr[i];

            if (timeTaken > mid) {
                totalPainters++;
                timeTaken = arr[i];
            }

            if (totalPainters > painters) {
                return totalPainters;
            }
        }

        if (timeTaken > 0){
            totalPainters++;
        }

        return totalPainters;
    }
    public static void main(String[] args) {
        System.out.println(paint(2, 5, new int[]{1, 10, 1, 10}));
    }
}
