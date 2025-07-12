package Strings;

import java.util.HashMap;
import java.util.Map;

public class LC13RomanToInteger {
    public int romanToInt(String s) {
        // Map to store the roman equivalent
        Map <Character, Integer> map = new HashMap <> ();
        map.put('I', 1);    
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int n = s.length();
        int result = map.get(s.charAt(n - 1));
        int prev = result;
        for (int i = n - 2; i >= 0; i--) {
            int curr = map.get(s.charAt(i));
            if (curr < prev) {
                result -= curr;
            } else {
                result += curr;
            }
            prev = curr;
        }

        return result;
    }
}
