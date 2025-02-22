import java.util.*;
public class TwoSum{
    public static int[] twoSum(int[] nums, int target){
        Map <Integer, Integer> arr = new HashMap <> ();
        for (int i=0; i<nums.length; i++){
            int reqItem = target - nums[i];
            if (arr.containsKey(reqItem) && i != arr.get(reqItem)){
                return new int[]{arr.get(reqItem), i};
            }
            else arr.put(nums[i], i);
        }
        return null;
    }
    public static void main(String[] args) {
        int[] num = {2,34,5,3,5};
        int[] twoIndex = twoSum(num, 7);
        for (int item : twoIndex){
            System.out.println(item);
        }
    }
}