import java.util.*;

public class FindMissingRepeatingNumbers {
    public static int[] findMissingRepeatingNumbers(int[] nums) {
        int firstEle = findDuplicate(nums);
        int n = nums.length;

        // the sum of first natural numbers
        int actualSum = n*(n+1)/2;

        // the totalSum of the array with a repeated firstEle, so we find the diff of it
        int totalSum = -firstEle;
        for (int ele : nums){
            totalSum += ele;
        }

        int secondEle = actualSum - totalSum;

        return new int[]{firstEle, secondEle};
    }

    // finding the duplicated element
    public static int findDuplicate(int[] nums) {
        HashSet <Integer> hash = new HashSet <> ();

        for (int i=0; i<nums.length; i++) {
            if (!hash.add(nums[i])) {
                return nums[i];
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] result = findMissingRepeatingNumbers(new int[]{1, 2, 3, 6, 7, 5, 7});
        System.out.println(Arrays.toString(result));
    }
}
