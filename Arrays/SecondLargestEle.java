import java.util.*;
    public class SecondLargestEle {
    public static int getLargest(int[] arr){
        // Optimal Approach
        int largestEle = arr[0];
        int secondLargestEle = Integer.MIN_VALUE;

        for (int ele : arr){
            if (ele > largestEle){
                secondLargestEle = largestEle;
                largestEle = ele;
            }

            if (ele > secondLargestEle && ele < largestEle){
                secondLargestEle = ele;
            }
        }

        return secondLargestEle;

        // the bruteforce approach is to sort the array and return the second last element which is
        // also not equal to the last element : O(n log n + n)
        // The better solution would be to find the largest element in the array 
        // and then find the second largest element : O(n + n)
        // where as in this optimal solution it takes only n 
    }
    public static void main(String[] args) {
        System.out.println(getLargest(new int[]{3,4,55,6,77,7,77,0,-34}));
    }
}
