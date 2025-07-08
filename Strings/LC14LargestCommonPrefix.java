package Strings;

import java.util.Arrays;

class LC14LargestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) return strs[0];

        String commonPrefix = "";
        for (int i = 0; i < strs.length - 1; i++) {
        String str1 = strs[i];
        String str2 = strs[i + 1];

        // if the first character is the same
        // then we know there can be a longest common prefix
        if (!str1.isEmpty() && !str2.isEmpty() && str1.charAt(0) == str2.charAt(0)) {
            // if it is empty, then we didn't have sequence before so start comparing
            if (commonPrefix.isEmpty()) {
            commonPrefix = findLcsBetweenTwo(str1, str2);
            }
            // if it is not empty, then we need to check it with the common seq before
            // and finally the commmon sequence will be storing the new sequence
            else {
            commonPrefix = findLcsBetweenTwo(commonPrefix, str2);
            }
        } else {
            return "";
        }
        }

        return commonPrefix;
        }

        public String findLcsBetweenTwo(String str1, String str2) {
        StringBuilder lcs = new StringBuilder();

        int i = 0;
        while (i < str1.length() && i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
        lcs.append(str1.charAt(i++));
        }

        return lcs.toString();
    }

    // optimal
    public String longestCommonPrefixOptimal(String[] strs) {
        Arrays.sort(strs); 

        String firstWord = strs[0];
        String lastWord = strs[strs.length - 1];

        int count = 0;
        for (int i=0; i<firstWord.length(); i++) {
            if (firstWord.charAt(i) == lastWord.charAt(i)) {
                count++;
            }
            else {
                break;
            }
        }

        return firstWord.substring(0, count);
    }
    public static void main(String[] args) {
        
    }
}