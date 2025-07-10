package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC451SortCharacters {
    public String frequencySort(String s) {
        Map <Character, Integer> map1 = new HashMap <> ();
        Map <Integer, List<Character>> map2 = new HashMap <> ();
        StringBuilder result = new StringBuilder();
        int max = Integer.MIN_VALUE;

        // counting the freq of all the characters
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        // iterate through the map and just reverse the key-value order
        for (char key : map1.keySet()) {
            int value = map1.get(key);

            if (!map2.containsKey(value)) {
                map2.put(value, new ArrayList <> ());
            } 

            List <Character> temp = map2.get(value);
            temp.add(key);

            max = Math.max(max, value);
        }

        // iterate from the max to 1, and the characters in the result
        for (int i=max; i>0; i--) {
            if (map2.containsKey(i)) {
                List <Character> temp2 = map2.get(i);

                for (char c : temp2) {
                    int count = i;
                    while (count != 0) {
                        result.append(c);
                        count--;
                    }
                }
            }
        }

        return result.toString();
    }
}
