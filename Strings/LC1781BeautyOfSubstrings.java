package Strings;

public class LC1781BeautyOfSubstrings {
    public int beautySum(String s) {
        int result = 0;

        for (int i=0; i<s.length(); i++) {
            int[] freq = new int[26];
            for (int j=i; j<s.length(); j++) {
                freq[s.charAt(j) - 'a']++;

                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;

                for (int ele : freq) {
                    if (ele != 0) {
                        max = Math.max(max, ele);
                        min = Math.min(min, ele);
                    }
                }
                
                result += (max - min);
            }
        }

        return result;
    }
}
