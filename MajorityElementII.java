import java.util.*;
import java.util.stream.Collectors;

public class MajorityElementII {
    public static List <Integer> majorityElement(int[] nums) {
        int len = nums.length;
        int majority = (int)Math.floor(len/3);

        Map <Integer, Integer> map = new HashMap <> ();
        HashSet <Integer> hash = new HashSet <> ();

        for (int i=0; i<len; i++) {
            int no = nums[i];
            int freq = map.getOrDefault(no,0) + 1;
            map.put(no, freq);

            if (freq>majority){
                hash.add(no);
            }
        }
        
        ArrayList <Integer> arr = (ArrayList<Integer>)hash.stream().collect(Collectors.toList());
        return arr;
    }

    // optimal approach to solve this problem
    public static List <Integer> majorityElementOptimal(int[] nums) {
        int n = nums.length;

        int count1=0;
        int ele1=Integer.MIN_VALUE;
        int count2=0;
        int ele2=Integer.MIN_VALUE;

        for (int i=0; i<n; i++) {
            if (count1==0 && nums[i]!=ele2){
                count1=1;
                ele1=nums[i];
            }
            else if (count2==0 && nums[i]!=ele1){
                count2=1;
                ele2=nums[i];
            }
            else if (ele1==nums[i]){
                count1++;
            }
            else if (ele2==nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        // now we check the whole array again and check whether the numbers are really greater than n/3
        count1=0;
        count2=0;
        List <Integer> finalList = new ArrayList <> ();

        for (int i=0; i<n; i++) {
            if(nums[i]==ele1)
                count1++;
            else if (nums[i]==ele2)
                count2++;
        }

        int majority = (int)Math.floor(n/3);
        if (count1>majority)
            finalList.add(ele1);
        if (count2>majority)
            finalList.add(ele2);

        return finalList;
    }
    public static void main (String[] args) {
        System.out.println(majorityElement(new int[]{-1,-1,-2,-2}));
        System.out.println(majorityElementOptimal(new int[]{-1,-1,-2,-2}));
    }
}
