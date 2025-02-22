public class MaxConsecutiveOnes {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxOccur = 0;
        int currentOccur = 0;
        
        for (int i=0; i<nums.length; i++){
            // when the element is the same we just count the current occurence
            if (nums[i] == 1){
                currentOccur++;
            }
            // here if the element is different we reset the currentOccur, ele and also checks
            // whether the currentOccur is greater than maxOccur 
            else {
                if (currentOccur > maxOccur) maxOccur = currentOccur;
                currentOccur = 0;
            }
        }
        // if the last consecutive ones happens to be at the end
        // for that reason we need to check once again here.
        if (currentOccur > maxOccur) maxOccur = currentOccur;

        return maxOccur;
    }
    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{1,1,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1}));
    }    
}
