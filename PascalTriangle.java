import java.util.*;

public class PascalTriangle {
    // generate Pascal's triangle based on the numRows
    public static List<List<Integer>> generate(int numRows) {
        List <List<Integer>> list = new ArrayList<>();
        // when the numRows is 1
        list.add(new ArrayList <>());
        list.get(0).add(1);
        if(numRows==1)
            return list;
        
        // when the numRows is 2
        list.add(new ArrayList <> ());
        list.get(1).add(1);
        list.get(1).add(1);
        if (numRows==1)
            return list;
        
        int flag = 2;
        while (flag < numRows) {
            List <Integer> temp = list.get(flag-1);
            List <Integer> newRow = new ArrayList <> ();
            int len = temp.size();

            // adding one to the 0th position
            newRow.add(1);

            for (int i=0; i<len-1; i++) {
                int sum = temp.get(i) + temp.get(i+1);
                newRow.add(sum);
            }

            // lastly add 1 to the end of the row
            newRow.add(1);

            // add the newRow to the list and increment the flag
            list.add(newRow);
            flag++;
        }

        return list;
    }

    // given row and col with 1-based indexing, find the number at that pos in Pascal's Triangle
    public static int findNumber(int row, int col) {
        row=row-1;
        col=col-1;

        int numerator = 1;
        int denominator = 1;
        int number = 1;

        for (int i=0; i<col; i++) {
            numerator *= (row - i);
            denominator *= (i+1);
        }
        number = (numerator * number) / denominator;
        
        return number;
    }

    // given : row number
    // generate the whole row in the pascal's triangle
    // bruteforce
    public static List <Integer> findRow(int rowNum) {
        int col = 0;
        int row = rowNum-1;
        List <Integer> list = new ArrayList <> ();

        while (col < rowNum) {
            int numerator = 1;
            int denominator = 1;
            int number = 1;

            for (int i=0; i<col; i++) {
                numerator *= (row - i);
                denominator *= (i+1);
                // System.out.println("numerator : "+numerator+" denominator : "+denominator);
            }
            number = (numerator * number) / denominator;

            list.add(number);
            col++;
        }

        return list;
    }

    // optimal
    public static List <Integer> findRow2(int rowNum) {
        List <Integer> list = new ArrayList <> ();
        list.add(1);
        int ans = 1;

        for (int i=1; i<rowNum-1; i++) {
            ans = ans * (rowNum - i);
            ans = ans / i;
            list.add(ans);
        }
        list.add(1);

        return list;
    }
    public static void main(String[] args) {
        System.out.println(generate(6));
        System.out.println(findNumber(5, 2));
        System.out.println(findRow(4));
        System.out.println(findRow2(4));
    }
}
