public class RemoveElement {
    static int removeElement(int[] nums, int val){
        int count = 0;
        int len = nums.length;
        // to find the total occurence of val inside num
        for (int i=0; i<len; i++){
            if (nums[i] == val){
                count++;
            }
        }
 
        // taking a variable j to store the index of any value other than val
        int j = len - 1;
        
        // the array shouldn't contain any value in the first len - count elements
        for (int i=0; i<len-count; i++){

            // if any value is there in the first len - count ele
            if (nums[i] == val){
                
                // find a element from j which is not val and swap the values
                while (nums[j] == val){j--;}
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        for (int ele : nums){
            System.out.print(ele + " ");
        }

        // finally return count (k)
        return len - count;
    }
    public static void main(String[] args) {
        int[] arrInp = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(arrInp, 2));
    }
}
