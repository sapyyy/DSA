import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring1(String s) {
        // the bruteforce approach
        int n = s.length();
        int maxLen = 0;
        for (int i=0; i<n; i++) {
            Set <Character> hash = new HashSet <> ();
            for (int j=i; j<n; j++) {
                if (!hash.add(s.charAt(j))) {
                    break;
                }
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLen = 0;
        int l = 0;
        int r = 0;

        Set <Character> hash = new HashSet <> ();

        while (r < n) {
            while (!hash.add(s.charAt(r))) {
                hash.remove(s.charAt(l));
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
    public static void main (String[] args) {
        System.out.println(lengthOfLongestSubstring1("abcabcbb"));
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
}
