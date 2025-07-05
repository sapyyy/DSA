package POTD;

import java.util.*;

public class LC1394LuckyInteger {
    // my soln
    public int findLucky(int[] arr) {
        int maxLucky = -1;

        Map <Integer, Integer> map = new HashMap <> ();
        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (key == map.get(key) && key > maxLucky) {
                maxLucky = key;
            }
        }

        return maxLucky;
    }

    // optimal
    public int findLuckyOptimal(int[] arr) {
       int[] hash = new int[501];
       for (int ele : arr) {
            hash[ele]++;
       }

       for (int i=500; i>0; i--) {
            if (hash[i] == i)
                return i;
       }

       return -1;
    }
   public static void main (String[] args) {
   } 
}
