package StackAssignment;

/*3. Write a method in a separate class to evaluate a postfix expression (Consider more than single
digit number as a input). */

import java.util.*;

public class PostfixExpression {
    static int evaluatePostfixExp(String exp) throws StackUnderflowed, StackOverflowed{
        int len = exp.length();
        MyStack <String> stack = new MyStack <> (len);
        MyStack <String> infix = new MyStack <> (len);

        String operators = "*+-/^";

        // using StringTokenizer 
        StringTokenizer str = new StringTokenizer(exp, " ");

        while (str.hasMoreTokens()){
            // contains the current token
            String cur = str.nextToken(); 

            // if it is operator pop from the stack and then calculate and add them back to the stack
            if (operators.contains(cur)){
                // pop two stack elements and then perform the operation and push it back
                String op1 = infix.pop();
                String op2 = infix.pop();

                int operand1 = Integer.parseInt(stack.pop());
                int operand2 = Integer.parseInt(stack.pop());

                // based on the operator perform the operation and push it back to the stack
                if (cur.equals("*")){
                    int product = operand1 * operand2;
                    String s = "(" + op2 + "*" + op1 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(product));
                }
                else if (cur.equals("/")){
                    int div = operand2 / operand1;
                    String s = "(" + op2 + "/" + op1 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(div));
                }
                else if (cur.equals("-")){
                    int diff = operand2 - operand1;
                    String s = "(" + op2 + "-" + op1 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(diff));
                }
                else if (cur.equals("+")){
                    int sum = operand2 + operand1;
                    String s = "(" + op2 + "+" + op1 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(sum));
                }
                else {
                    int power = (int) Math.pow(operand2, operand1);
                    String s = "(" + op2 + "^" + op1 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(power));
                }
            }
            else {
                stack.push(cur);
                infix.push(cur);
            }
        }

        System.out.println("The infix expression : "+infix.pop());

        // lastly return the final element as integer1
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args) throws StackUnderflowed, StackOverflowed {
        System.out.println("The value after evaluation : "+evaluatePostfixExp("12 3 4 * + 5 -"));
    }
}
