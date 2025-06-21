import java.util.*;
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        Map <Character, Integer> map = new HashMap <> ();
        Map <Character, Integer> map2 = new HashMap <> ();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        for (int i=0; i<t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i),0)+1);
        }

        if (map.equals(map2)){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
