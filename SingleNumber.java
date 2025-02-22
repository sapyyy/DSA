import java.util.*;
public class SingleNumber {
    public static int singleNumber(int [] arr){
        Map <Integer, Integer> freq = new HashMap <> ();
        
        for (int i = 0; i<arr.length; i++){
            freq.put(arr[i], freq.getOrDefault(arr[i], 0)+1);
        }

        for (int i : freq.keySet()){
            if (freq.get(i) == 1){
                return i;
            }
        }

        return 0;
    }
    public static void main(String[] args) {
        int no = singleNumber(new int[] {2,4,5,5,4,2,3});
        System.out.println(no);
    }
}
