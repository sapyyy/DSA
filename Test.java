import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{3, 1}, {1, 3}, {1, 1}};
        Comparator <int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
            }
        };

        Arrays.sort(arr, comp);
        
        for (int[] pair : arr) {
            System.out.println(Arrays.toString(pair));
        }

    }
}
