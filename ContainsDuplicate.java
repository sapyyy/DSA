import java.util.*;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set <Integer> hash = new HashSet <> ();

        int n = nums.length;
        for (int i=0; i<n; i++) {
            if (!hash.add(nums[i])) return true;
        }

        return false;
    }
    public static void main(String[] args) {
        
    }
}
