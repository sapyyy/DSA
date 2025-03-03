import java.util.Arrays;

public class MatrixMulltiplication {
    public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2){
        int [][] finalMatrix = new int[arr1.length][arr2[0].length];

        int row1 = arr1.length;
        int col2 = arr2[0].length;
        int row2 = arr2.length;

        for (int i=0; i<row1; i++){
            for (int j=0; j<col2; j++){
                for (int k=0; k<row2; k++){
                    finalMatrix[i][j] += arr1[i][k] * arr2[k][j]; 
                }
            }
        }

        return finalMatrix;
    }
    public static void main(String[] args) {
        int[][] matrix1 = {
        {1, 1, 1},
        {2, 2, 2},
        {3, 3, 3}};

        int[][] matrix2 = {
        {1, 1, 1},
        {2, 2, 2},
        {3, 3, 3}};
            
        int[][] finalArr = matrixMultiplication(matrix1, matrix2);

        for (int[] ele : finalArr){
            System.out.println(Arrays.toString(ele));
        }
    }

}
