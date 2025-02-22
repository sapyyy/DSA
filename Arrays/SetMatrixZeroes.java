public class SetMatrixZeroes{
    public static void setZeroes(int[][] arr){
        // variables to store the length of the row and col
        int rlen = arr.length;
        int clen = arr[0].length;

        // two sets for storing the row and col, so that we don't try to change the values again later
        // Set <Integer> setr = new HashSet <> ();
        // Set <Integer> setc = new HashSet <> ();

        // loop through the array and then search for 0
        int col0 = 1;
        for (int i=0; i<rlen; i++){
            for (int j=0; j<clen; j++){
                if (arr[i][j] == 0){
                    // then add the ith ele to row and jth ele to the setc
                    // if (!setr.contains(i)) setr.add(i);
                    // if (!setc.contains(j)) setc.add(j);
                    arr[i][0] = 0;

                    if (j != 0){
                        arr[0][j] = 0;
                    } 
                    else
                        col0 = 0;
                }
            }
        }
        
        for (int i=1; i<rlen; i++){
            for (int j=1; j<clen; j++){
                if (arr[i][0] == 0 || arr[0][j] == 0){
                    arr[i][j] = 0;
                }
            }
        }

        if (arr[0][0] == 0){
            for (int j=1; j<clen; j++) arr[0][j] = 0;
        }
        if (col0 == 0){
            for (int i=0; i<rlen; i++) arr[i][0] = 0;
        }

        // now just for the array, change the rows and cols which has zero
        // setr.forEach(m -> {
        //     for(int i=0; i<clen; i++) 
        //         arr[m][i] = 0;
        // });

        // setc.forEach(n -> {
        //     for(int i=0; i<rlen; i++)
        //         arr[i][n] = 0;
        // });

        for (int i=0; i<rlen; i++){
            for (int j=0; j<clen; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main (String[] args){
        int[][] a = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(a);
    }
}