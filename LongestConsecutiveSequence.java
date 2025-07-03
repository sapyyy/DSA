import java.util.*;
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
            Set <Integer> hash = new HashSet <Integer> ();
            for (int ele : nums) {
                hash.add(ele);
            }

            int maxConsecutive = 1;
            for (int ele : hash) {
                // if hash doesn't contain a number that is less than the current number 
                // then there might be a sequence of consecutive numbers starting from the current number
                int countConsecutive = 1;
                if (!hash.contains(ele-1)) {
                    int nextNum = ele + 1; 
                    while (hash.contains(nextNum)) {
                        countConsecutive++;
                        nextNum++;
                    }
                    maxConsecutive = Math.max(maxConsecutive, countConsecutive);
                }
            }

        return maxConsecutive;
    }  
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,0,1,2}));
    }
}