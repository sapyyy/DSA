import java.util.*;

public class UnionOfTwoArr {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList <Integer> arr = new ArrayList <> ();

        int i = 0, j = 0;
        while (i < a.length && j < b.length){
            // when a[i] is less than b[j]
            if (a[i] <= b[j]){
                if (arr.size() == 0 || arr.getLast() != a[i]){
                    arr.add(a[i]);
                }
                i++;
            }
            else if (a[i] > a[j]){
                if (arr.size() == 0 || arr.getLast() != b[j]){
                    arr.add(a[j]);
                }
                j++;
            }
        }
        
        // when there's some elements in both the arrays 
        // we just traverse the array and put them into the arr

        while (i < a.length){
            if (arr.getLast() != a[i]){
                arr.add(a[i]);
            }
            i++;
        }

        while (j < b.length){
            if (arr.getLast() != b[j]){
                arr.add(b[j]);
            }
            j++;
        }

        return arr;
    }
    public static void main(String[] args) {
        System.out.println(findUnion(new int[]{1,2,3,4,5}, new int[]{2,3,4,5,6,7}));
    }
}
