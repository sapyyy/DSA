package Recursion;

import java.util.*;

public class SubSetIIOptimal {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List <List<Integer>> res = new ArrayList <> ();
        Arrays.sort(nums);
        findSubset(0, nums, new ArrayList <> (), res);
        return res;
    }
    
    public void findSubset(int index, int[] nums, List <Integer> ds, List <List<Integer>> res) {
        res.add(new ArrayList <> (ds));
        for (int i=index; i<nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            ds.add(nums[i]);
            findSubset(i + 1, nums, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}
