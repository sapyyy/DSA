package Stack;

import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack <Integer> stack = new Stack <> ();

        for (int i=2*n - 1; i>=0; i--) {
            int cur = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }

            if (i < n) {
                if (stack.isEmpty()) {
                    result[i] = -1;
                }
                else {
                    result[i] = stack.peek();
                }
            }

            stack.push(cur);
        }    

        return result;    
    }
}
