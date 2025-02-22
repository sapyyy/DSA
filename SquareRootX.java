import java.util.*;

public class SquareRootX{
    static int squarex(int x){
        List <Integer> arr = new ArrayList<>();

        for (int i=1; i<x/2; i++){
            arr.add(i);
        }

        int first = 0;
        int last = arr.size();

        while (first < last){
            int mid = (first + last)/2;

            if (arr.get(mid) * arr.get(mid) <= x){
                return mid;
            } 

            else if (arr.get(mid) * arr.get(mid) > x){
                last = mid - 1;
            }
        }

        return 0;
    }
    public static void main (String[] args){
        System.out.println(squarex(35));
    }
}