import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementHalfN {
    public static int majorityElement(int[] nums){
        Map <Integer, Integer> digOccur = new HashMap <> ();
        for (int i=0; i<nums.length; i++){
            if (digOccur.containsKey(nums[i])){
                digOccur.put(nums[i], digOccur.get(nums[i])+1);
            }
            else{
                digOccur.put(nums[i], 1);
            }
        }

        for (int ele : digOccur.keySet()){
            if (digOccur.get(ele) > (nums.length/2)){
                return ele;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int finalEle = majorityElement(new int[]{3,2,3});
        System.out.println(finalEle);
    }
}
