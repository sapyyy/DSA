package Strings;

import java.util.*;

public class LC205IsomorphicStrings {
    // bruteforce
    public boolean isIsomorphic(String s, String t) {
        Map <Character, Character> map = new HashMap <> ();

        // mapping each chars of s to t
        for (int i=0; i<s.length(); i++) {
            char first = s.charAt(i);
            char second = t.charAt(i);

            // if there is any mismatch we return 
            if (map.containsKey(first) && map.get(first) != second)
                return false;
            // no to characters should map to the same character
            if (!map.containsKey(first) && map.containsValue(t.charAt(i)))
                return false;
                
            map.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }   

    // optimal
}
