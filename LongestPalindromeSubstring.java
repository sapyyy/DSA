public class LongestPalindromeSubstring {
    public static String longestPalindrome(String s) {
        // edge case
        if (s.length() == 1){
            return s;
        }
        // use two pointers to find the longest sequence
        int len = s.length();
        // store inside a variable
        String largestSub = Character.toString(s.charAt(0));
        for (int i=0; i<len; i++){
            // for every i find the largest sequence
            String tempStr = Character.toString(s.charAt(i));
            for (int j=i+1; j<len; j++){
                tempStr += s.charAt(j);
                // here we check if the tempStr contains a palindrome which is larger than the current subsequence
                if (checkPalindrome(tempStr) && tempStr.length() > largestSub.length())
                    largestSub = tempStr;
                    // else we add elements until we get another string with bigger length
            }
        }

        // finally return the bigger substring
        return largestSub;
    }

    // method to check if a string is boolean or not
    public static boolean checkPalindrome(String s){
        String rev = "";

        for (int i = 0; i<s.length(); i++){
            rev = s.charAt(i) + rev;
        }

        if (s.equals(rev)) return true;

        return false;
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
