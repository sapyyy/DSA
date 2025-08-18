package Recursion;

import java.util.*;

public class SubsetII {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set <List<Integer>> res = new HashSet <> ();
        Arrays.sort(nums);
        findUniqueSubset(0, nums, new ArrayList <> (), res);
        return new ArrayList(res);
    }

    public void findUniqueSubset(int index, int[] nums, List <Integer> ds, Set <List<Integer>> res) {
        // base case
        if (index >= nums.length) {
            res.add(new ArrayList <> (ds));
            return;
        }
            
        ds.add(nums[index]);
        findUniqueSubset(index + 1, nums, ds, res);
        ds.remove(ds.size() - 1);
        findUniqueSubset(index + 1, nums, ds, res);
    }
    public static void main(String[] args) {
        
    }
}
