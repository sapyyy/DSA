// Moore's Voting Algorithm is an optimal algorithm, which is used to find the majority element
// among elements which has more than n/2 occurences.
// Time : O(n) & Space : O(1)

public class MooresVotingAlgorithm {
    public static int mooresVoteAlgo(int[] nums){
        int len = nums.length;
        int occur = 0;
        int ele=-1;


        for (int i=0; i<len; i++){
            // if the occurence is 0, initialize ele with nums[i]
            if (occur == 0){
                ele = nums[i];
                occur = 1;
            }
            else if (nums[i] == ele)
                occur++;
            else
                occur--;
        }


        // then check if the element has more than n/2 occurence,
        // return if so, else we can conclude that there is no element having n/2 occurence
        int cnt = 0;
        for (int i=0; i<len; i++){
            if (ele == nums[i]){
                cnt++;
            }
        }

        if (cnt > len/2)
            return ele;

        return 0;
    }
    public static void main(String[] args) {
        System.out.println(mooresVoteAlgo(new int[]{2,2,2,4,4,4,4}));
    }
}
