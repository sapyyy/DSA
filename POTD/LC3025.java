package POTD;

import java.util.Arrays;
import java.util.Comparator;

public class LC3025 {
     public int numberOfPairs(int[][] points) {
        // use comparator to sort the points[0] as ascending
        // and points[1] as descending
        Comparator <int[]> comp = new Comparator <int[]> () {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? a[0] - b[0] : b[1] - a[1];
            }
        };

        Arrays.sort(points, comp);

        int placed = 0;
        for (int i=0; i<points.length; i++) {
            int firstY = points[i][1];
            int maxY = -1;
            for (int j=i+1; j<points.length; j++) {
                int secondY = points[j][1];
                if (firstY >= secondY && secondY > maxY) {
                    placed++;
                    maxY = secondY;
                }
            }
        }

        return placed;
    }
    public static void main(String[] args) {
        
    }
}
