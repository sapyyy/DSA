/* You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
 */
import java.util.*;

public class TriangleType {
    public String triangleType(int[] nums) {
        // bruteforce is we try to solve by comparing one element with the others
        int len = nums.length;
        int sidesEqual = 0;

        // check if all the three sides doesn't form a triangle
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1])
            return "none";

        for (int i=0; i<len; i++) {
            for (int j = 0; j < len; j++) {
                // the index shouldn't be same
                if (i == j)
                    continue;

                // if both the numbers are not at the same position and they are equal we increment the sidesEqual
                if (nums[i]==nums[j]) {
                    ++sidesEqual;
                }
            }
        }

        // finally check the type of triangle
        if (sidesEqual==0)
            return "scalene";
        else if (sidesEqual==2)
            return "isosceles";
        else
            return "equilateral";
    }

    // using hashing
    public String triangleType2(int[] nums) {
        // check if all the three sides doesn't form a triangle
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1])
            return "none";

        // storing the values and their counts in hashmap
        Map <Integer, Integer> hash = new HashMap <> ();

        // looping through the array and updating the frequency
        for (int i=0; i<nums.length; i++){
            if (hash.containsKey(nums[i])){
                hash.put(nums[i], hash.get(nums[i]) + 1);
            }
            else {
                hash.put(nums[i], 1);
            }
        }

        // finally checking the type of the triangle
        if (hash.containsValue(3))
            return "equilateral";

        if (hash.containsValue(2))
            return "isosceles";

        return "scalene";
    }

    // using array hash
    public String triangleType3(int[] nums) {
        // check if all the three sides doesn't form a triangle
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1])
            return "none";

        int len = nums.length;
        int[] arrHash = {0,0,0};

        for (int ele : nums) {
            if (ele==nums[0])
                arrHash[0] += 1;
            else if (ele==nums[1])
                arrHash[1] += 1;
            else if (ele==nums[2])
                arrHash[2] += 1;
        }

        for (int freq : arrHash) {
            if (freq==3)
                return "equilateral";

            if (freq==2)
                return "isosceles";
        }

        return "scalene";
    }

    // optimal
    public String triangleType4(int[] nums) {
        // check if all the three sides doesn't form a triangle
        if (nums[0] + nums[1] <= nums[2] || nums[1] + nums[2] <= nums[0] || nums[0] + nums[2] <= nums[1])
            return "none";

        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        if (a == b && b == c)
            return "equilateral";
        else if (a == b || b == c || c == a)
            return "isosceles";

        return "scalene";
    }
    public static void main(String[] args) {
        System.out.println(new TriangleType().triangleType(new int[]{8,4,2}));
    }
}
