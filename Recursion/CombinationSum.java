package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List <List<Integer>> result = new ArrayList <> ();
        findCombination(0, target, new ArrayList <> (), candidates, result);
        return result;
    }
    public void findCombination(int index, int target, List <Integer> ds, int[] candidates, List <List<Integer>> result) {
        // check if the index goes out of bound here
        if (index >= candidates.length) {
            if (target == 0) {
                result.add(new ArrayList(ds));
            }
            return;
        }

        // we need to ensure that taking another number doesn't make
        // the target go in negative
        if (candidates[index] <= target) {
            ds.add(candidates[index]);
            findCombination(index, target - candidates[index], ds, candidates, result); // take logic
            ds.remove(ds.size() - 1);
        }

        // don't take logic but we also go to the next element
        findCombination(index + 1, target, ds, candidates, result);
    }
    public static void main (String[] args) {
    }
}
