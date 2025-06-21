import java.util.*;

public class SpiralOrder {
    public static List<Integer> spiralOrder(int[][] arr) {
        int left = 0;
        int right = arr[0].length-1;
        int top = 0;
        int down = arr.length-1;

        List <Integer> list = new ArrayList <> ();

        while (left <= right) {
            for (int j=left; j<=right; j++) {
                // System.out.print(arr[left][j] + " ");
                list.add(arr[left][j]);
            }
            top++;

            for (int j=top; j<=down; j++) {
                // System.out.print(arr[j][right] + " ");
                list.add(arr[j][right]);
            }
            right--;

            for (int j=right; j>=left; j--){
                // System.out.print(arr[down][j] + " ");
                list.add(arr[down][j]);
            }
            down--;

            for (int j=down; j>=top; j--) {
                // System.out.print(arr[j][left] + " ");
                list.add(arr[j][left]);
            }
            left++;
        }

        return list;
    }
    public static void main (String[] args) {
        spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }
}
