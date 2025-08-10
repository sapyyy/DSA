package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
        List <List<Integer>> result = new ArrayList <> ();
        List <Integer> temp = new ArrayList <> ();
        countSubsets(0, arr, result, temp);

        return result;
    }

    public static void countSubsets(int index, int[] arr, List <List<Integer>> result, List <Integer> temp) {
        int n = arr.length;
        // when the index is n - 1 then add it to the result
        if (index >= n) {
            result.add(new ArrayList <> (temp));
            return;
        }

        temp.add(arr[index]); // -> take this number
        countSubsets(index + 1, arr, result, temp);

        temp.remove(temp.size() - 1); // -> don't take this number
        countSubsets(index + 1, arr, result, temp);
    }
}
