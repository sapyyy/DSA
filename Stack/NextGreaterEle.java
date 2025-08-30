package Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterEle {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Map <Integer, Integer> map = new HashMap <> ();
        Stack <Integer> stack = new Stack <> ();

        for (int i=0; i<nums1.length; i++) {
            map.put(nums1[i], i);
        }

        for (int i=0; i<nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && stack.peek() < cur) {
                int val = stack.pop();
                int indexVal = map.get(val);
                result[indexVal] = cur;
            }

            // check if the element is also there in the first nums
            if (map.containsKey(cur)) {
                stack.push(cur);
            }
        }

        return result;
    }
}
