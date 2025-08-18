package Recursion;

import java.util.*;

public class SubsetsSum {
    public static List<Integer> subsetSums(int[] nums) {
        List <Integer> res = new ArrayList <> ();
        findSubsetSum(0, 0, nums, res);
        return res;
    }

    public static void findSubsetSum(int index, int sum, int[] nums, List <Integer> res) {
        // base condition 
        if (index >= nums.length) {
            res.add(sum);
            return;
        }

        findSubsetSum(index + 1, sum + nums[index], nums, res);
        findSubsetSum(index + 1, sum, nums, res);
    }
    
    public static void main (String[] args) {
        System.out.println(subsetSums(new int[]{5,2,1}));
    }
}
