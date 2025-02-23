public class SortColors {
    public static void sortColors(int[] nums){
        // will take an array to perform hashing
        int[] arr = new int[3];

        // hash the values inside an array
        for (int i=0; i<nums.length; i++){
            arr[nums[i]]++;
        }

        int j = 0;
        // according to the array position sort the array inplace
        for (int i=0; i<nums.length; i++){
            while (arr[j] == 0){
                j++;
            }

            nums[i] = j;
            --arr[j];
        }

        for (int ele : nums){
            System.out.print(ele + " ");
        }
    }
    public static void main(String[] args) {
        sortColors(new int[] {2,2,2,2,0,0,0,0,1,1,1,1,1});
    }
}
