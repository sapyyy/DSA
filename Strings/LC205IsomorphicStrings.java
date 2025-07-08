package Strings;

import java.util.*;

public class LC205IsomorphicStrings {
    // bruteforce
    public boolean isIsomorphic(String s, String t) {
        Map <Character, Character> map = new HashMap <> ();
        Set <Character> hash = new HashSet <> ();
        StringBuilder mapped = new StringBuilder();

        // mapping each chars of s to t
        for (int i=0; i<s.length(); i++) {
            // if there is any mismatch we return 
            if (map.get(s.charAt(i)) != null && map.get(s.charAt(i)) != t.charAt(i))
                return false;
            // no to characters should map to the same character
            if (map.get(s.charAt(i)) == null && hash.contains(t.charAt(i)))
                return false;
                
            map.put(s.charAt(i), t.charAt(i));
            hash.add(t.charAt(i));
        }

        // creating a mapped string for comparision
        for (int i=0; i<s.length(); i++) {
            mapped.append(map.get(s.charAt(i)));
        }

        return mapped.toString().equals(t);
    }   
}
