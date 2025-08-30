package Stack;

import java.util.*;

public class InfixToPostFix {
    public static String convertInfixToPostfix(String infix) {
        Stack <Character> st = new Stack <> ();
        StringBuilder postfix = new StringBuilder();

        for (int i = 0; i<infix.length(); i++) {
            char ch = infix.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            else if (ch == '(') {
                st.push(ch);
            }
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(st.pop());
                }
                if (!st.isEmpty()) st.pop();
            }
            else {
                // check for every precedence and then add every item
                if (st.isEmpty() || st.peek() == '(') {
                    st.push(ch);
                }
                else {
                    char lastEle = st.peek();
                    if (getOperatorPrecedence(ch) > getOperatorPrecedence(lastEle)) {
                        st.push(ch);
                        }
                    else {
                        while (!st.isEmpty() && st.peek() != ')') {
                            postfix.append(st.pop());
                        }
                    }
                }
            }
        }

        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }

        return postfix.toString();
    }
    public static int getOperatorPrecedence(char c) {
        switch(c) {
            case '+':
                return 1;
            case '-':
                return 1;
            case '/':
                return 2;
            case '*':
                return 2;
            default: 
                return -1;
        }
    }
    public static void main(String[] args) {
        System.out.println(convertInfixToPostfix("(p+q)*(m-n)"));
        System.out.println(convertInfixToPostfix("(a+b*(c-d))/((e-f)*(g+h/i))"));
    }
}
