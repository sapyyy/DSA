package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
     public List<List<Integer>> combinationSum3(int k, int n) {
        List <List<Integer>> res = new ArrayList <> ();
        findCombinations(0, n, new int[]{1,2,3,4,5,6,7,8,9}, k, new ArrayList <> (), res);
        return res;
    }

    public void findCombinations(int index, int target, int[] nums, int k, List <Integer> ds, List <List<Integer>> res) {
        if (k == 0 || index >= nums.length) {
            if (target == 0 && k == 0) {
                res.add(new ArrayList <> (ds));
            }
            return;
        }

        if (nums[index] <= target) {
            ds.add(nums[index]);
            findCombinations(index + 1, target - nums[index], nums, k - 1, ds, res);
            ds.remove(ds.size() - 1);
            findCombinations(index + 1, target, nums, k, ds, res);
        }
    }
}
