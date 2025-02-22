public class FirstAndLastElementIndex {

    public static int[] setIndex(int[] nums, int target, int starting, int ending){
        // first situation may arise the repeated elements are in the first half
        // like for the array 2,2,3,45,94,100
        while (starting >= 1 && nums[starting-1] == target) starting--;
        // and the second situation when the repeated elements are in the second half
        while (ending <= nums.length-2 && nums[ending+1] == target) ending++;
        // or the third situation when the index is in the middle

        // finally return the starting and ending
        return new int[]{starting, ending};
    }
    public static int[] searchRange(int[] nums, int target){
        // specifying the first and the last index here
        int first = 0;
        int last = nums.length - 1;
        
        // binary search as the array is already sorted
        while (first <= last) {
            int mid = (first + last)/2;
            if (nums[mid] == target){
                // if we find the target there could be three possibilities
                int[] indexes = setIndex(nums,target,mid,mid);

                return new int[]{indexes[0], indexes[1]};
            }
            else if (nums[mid] < target){
                first = mid + 1;
            }
            else last = mid - 1;
        }

        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,9,11,11,11,11,16,18,20};
        int[] firstLast = searchRange(arr, 11);

        for (int indx : firstLast){
            System.out.print(indx+" ");
        }
    }
}
