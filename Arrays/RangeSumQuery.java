public class RangeSumQuery {
    public static void main (String args[]) {

    }
}

class NumArray {
    private int[] prefix;

    public NumArray(int[] nums) {
        prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return left != 0 ? prefix[right] - prefix[left - 1] : prefix[right]; 
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */
