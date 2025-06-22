import java.util.*;
public class MaxDifferenceEvenOdd {
    public static int maxDifference(String s) {
        Map <Character, Integer> map = new HashMap <> ();

        int maxOdd = Integer.MIN_VALUE;
        int maxEven = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;

        int maxDiff = Integer.MIN_VALUE;

        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for (int val : map.values()) {
            if (val%2==0) {
                maxEven = Math.max(val, maxEven);
                minEven = Math.min(val, minEven);
            }
            else {
                maxOdd = Math.max(maxOdd, val);
            }
        }

        System.out.println(map);

        return maxOdd - minEven;
    }
    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc"));
        System.out.println(maxDifference("abcabcab"));
        System.out.println(maxDifference("mmsmsym"));
        System.out.println(maxDifference("uavuauuaaiuv"));
    }
}
