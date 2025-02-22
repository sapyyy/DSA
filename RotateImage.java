public class RotateImage {
    static void rotate(int[][] matrix){
        int n = matrix.length;

        // transpose of a matrix
        for (int i=0; i<n; i++){
            for (int j=i; j<n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // peform row reverse 
        for (int i=0; i<n; i++){
            for (int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }    
    public static void main(String[] args) {
        int[][] matrixNew = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrixNew);
    }
}