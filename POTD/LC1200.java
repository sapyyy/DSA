public class LC1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        // 4 2 1 3 -> [1,2], [2, 3], [3, 4]
        // sort the array
        // 1 2 3 4 -> minDiff -> 1 -> O(n)
        // loop again to find out the pairs with minDiff

        // 3,8,-10,23,19,-4,-14,27
        // -14, -10, -4, 3, 8, 19, 23, 27 (after sorting)
        int n = arr.length;
        List <List<Integer>> result = new ArrayList <> ();
        Arrays.sort(arr);

        int l = 0;
        int r = 1;

        // we find the minDiff here 
        int minDiff = Integer.MAX_VALUE;
        while (r < n) {
            minDiff = Math.min(minDiff, Math.abs(arr[r++] - arr[l++]));
        }

        // add the pairs which has minDiff
        l = 0;
        r = 1;
        while (r < n) {
            if (minDiff == Math.abs(arr[r] - arr[l])) {
                List <Integer> tempRes = new ArrayList <> ();
                tempRes.add(arr[l]);
                tempRes.add(arr[r]);
                result.add(tempRes);
            }

            l++;
            r++;
        }

        return result;
    }
    public static void main(String[] args) {
        
    }
}