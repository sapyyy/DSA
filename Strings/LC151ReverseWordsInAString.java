package Strings;

import java.util.*;

class LC151ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder result = new StringBuilder();
    
        for (int i=strArr.length-1; i>=0; i--) {
            String temp = strArr[i].trim();
            if (!temp.isEmpty()) {
                if (i != 0)
                    result.append(temp + " ");
                else   
                    result.append(temp);
            }
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("kore wa ramen desu ka"));
        System.out.println(reverseWords(" hello world "));

    }
}