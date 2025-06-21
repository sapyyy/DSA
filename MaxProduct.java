import java.util.*;
public class MaxProduct {
    public static int maxProductBrute(int[] nums) {
        int product = Integer.MIN_VALUE;

        for (int i=0; i<nums.length; i++){
            int tempProduct = nums[i];
            product = Math.max(product, tempProduct);

            // if temp is 0 then we store it if 0 is bigger or just continue
            if (tempProduct==0) {
                continue;
            }

            for (int j=i+1; j<nums.length; j++) {
                if (nums[j]==0) {
                    break;
                }
                tempProduct *= nums[j];
                product = Math.max(product, tempProduct);
            }
        }

        return product;
    }

    // not working
    public static int maxProductBetter(int[] nums) {
        Map <Integer, Integer> hash = new HashMap <> ();

        int prefixProd = Integer.MIN_VALUE;
        for (int i=0; i<nums.length; i++) {
            if (i==0 || prefixProd == 0){
                hash.put(nums[i],nums[i]);
                prefixProd = nums[i];
            }
            else {
                prefixProd *= nums[i];
                hash.put(nums[i], Math.max(hash.getOrDefault(nums[i],Integer.MIN_VALUE), prefixProd));
            }
        }

        // next we just traverse through the map values and find the largest to return
        int largest = Integer.MIN_VALUE;
        for (int ele : hash.values()){
            largest = Math.max(largest, ele);
        }

        return largest;
    }

    // prefix and suffix method
    public static int maxProductOptimal(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int prefixProd = 1;
        int suffixProd = 1;
        int n = nums.length;

        for (int i=0; i<n; i++) {
            if (prefixProd==0){
                prefixProd = 1;
            }
            if (suffixProd==0){
                suffixProd = 1;
            }
            prefixProd *= nums[i];
            suffixProd *= nums[n - i - 1];
            maxProd = Math.max(Math.max(prefixProd, suffixProd), maxProd);
        }

        return maxProd;
    }
    public static void main(String[] args) {
//        int[] nums = {-3,0,1,-2};
        int[] nums = {-2,0,-1};
//        int[] nums = {2, 3, -2, 4};
//        int[] nums = {3,-1,4};
        System.out.println(maxProductBrute(nums));
//        System.out.println(maxProductBetter(nums));
        System.out.println(maxProductOptimal(nums));
    }
}
