public class KadanesAlgorithm{
    public static void algorithm(int[] arr){
        // Kadane's algorithm is used to find the maximum subarray of an array
        // which has both positive and negative integers in it.

        // algorithm working and intitution :
        
        // take a variable to store the maximum sub array
        int largestSum = Integer.MIN_VALUE;

        // another variable to calculate the sum while traversing
        int sum = 0;
        int firstPointer = 0;
        int endPointer = 0;

        // iterate through the array
        for (int i = 0; i < arr.length; i++){
            if (sum == 0)
                firstPointer = i;

            // add the current element to the sum first
            sum += arr[i];


            // check if the current sum is larger than the largestSum and store if true
            if (sum > largestSum){
                largestSum = sum;
                endPointer = i;
            }

            // if the sum is negative then we reset the sum as 0
            if (sum < 0){
                sum = 0;
            }
        }
        
        System.out.print("The largest subarray : ");
        for (int i=firstPointer; i<=endPointer; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        System.out.println("The largest subarray sum is : "+largestSum);

    }
    public static void main(String[] args) {
        algorithm(new int[]{5,4,-1,7,8});
    }
}