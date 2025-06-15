import java.util.*;

public class SpiralMatrix54 {
    public List <Integer> spiralOrder(int[][] arr) {
        List <Integer> finalList = new ArrayList <> ();

        int row = arr.length - 1;
        int col = arr[0].length - 1;

        for (int i=0; i<=row/2; i++) {
            int startR = i;
            int startC = i;
            int endR = i;
            int endC = col - i;

            // row -> col
            for (int j = startC; j<=endC; j++) {
                finalList.add(arr[startR][j]);
            }

            // col -> row
            startC = endC;
            endR = row - i;
            for (int j = startR+1; j<=endR; j++) {
                finalList.add(arr[j][startC]);
            }

            // Reverse
            // col <- row
            startR = endR;
            endC = endC - (row - i);
            for (int j=startC-1; j>=endC; j--) {
                finalList.add(arr[startR][j]);
            }

            // row <- col
            startC = endC;
            endR = i + 1;
            for (int j=startR-1; j>=endR; j--) {
                finalList.add(arr[j][startC]);
            }
        }
        finalList.removeLast();
        return finalList;
    }
    public static void main(String[] args) {
        System.out.println(new SpiralMatrix54().spiralOrder(new int[][]{{1,2,3,4},
                                                                        {5,6,7,8},
                                                                       {9,10,11,12},
                                                                       {13,14,15,16}}));
    }
}
