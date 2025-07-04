package Strings;
import java.util.*;

public class LC1021RemoveOutermostParenthesis {
    public static String removeOuterParentheses(String s) {
      StringBuilder result = new StringBuilder();
     
      int count = 0;
      for (int i=0; i<s.length(); i++) {
        if (s.charAt(i) == '(') {
           if (count > 0) result.append('(');
           count++;
        }
        else {
            count--;
            if (count > 0) result.append(')');
        }
      }

      return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()()"));
        System.out.println(removeOuterParentheses("(()())(())"));
        System.out.println(removeOuterParentheses("(()()(()))((()))"));
        }
}
