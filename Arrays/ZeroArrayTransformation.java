public class ZeroArrayTransformation {
    // bruteforce approach - not passed (tle)
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int numLen = nums.length;
        int queryLen = queries.length;

        // we loop through the queries array and select every row's first and last index
        for (int i=0; i<queryLen; i++) {
            int startI = queries[i][0];
            int endI = queries[i][1];

            // for every element int the nums array if we find val > 0 we decrement
            for (int j=startI; j<=endI; j++) {
                if (nums[j]>0)
                    nums[j]--;
            }
        }

        // finally loop the array again to check if the array has values other than zero
        boolean allZeroes = true;
        for (int j : nums) {
            if (j != 0){
                allZeroes = false;
            }
        }

        // return true if every val are zeroes
        if (allZeroes) {
            return true;
        }

        // only when the val has some values other than zeroes
        return false;
    }

    public boolean isZeroArray2(int[] nums, int[][] queries) {
        int numLen = nums.length;
        int queryLen = queries.length;

        // for the queries we create a difference array which helps us do the
        // range update by O(1)
        int[] diff = new int[numLen + 1];
        for (int i=0; i<queryLen; i++) {
            int startI = queries[i][0];
            int endI = queries[i][1];

            // update the start index by 1
            diff[startI]++;
            // update the end + 1 index by -1
            diff[endI + 1]--;
        }

        // loop through the array and sum all of the values
        for (int i=1; i<diff.length; i++) {
            // update the diff array
            diff[i] += diff[i-1];
        }

        for (int i=0; i<diff.length-1; i++) {
            // check the diff[i] is greater than equal to the nums[i]
            if (diff[i]<nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean val = new ZeroArrayTransformation().isZeroArray(new int[]{4,3,2,1}, new int[][]{{1,3},{0,2}});
        boolean val2 = new ZeroArrayTransformation().isZeroArray2(new int[]{4,3,2,1}, new int[][]{{1,3},{0,2}});
        System.out.println(val);
        System.out.println(val2);
    }
}
