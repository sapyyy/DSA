package StackAssignment;

/*4. Write a method in a separate class to evaluate a prefix expression. (Consider more than single
digit number as a input */

import java.util.*;

public class PrefixExpression {
    static int evaluatePrefixExp(String exp) throws StackUnderflowed, StackOverflowed{
        int len = exp.length();
        MyStack <String> stack = new MyStack <> (len);
        MyStack <String> infix = new MyStack <> (len);

        String operators = "*+-/^";
        
        // logic to revere a string, also handling the brackets
        String rev = "";
        StringTokenizer str1 = new StringTokenizer(exp);
        while (str1.hasMoreTokens()){
            rev = str1.nextToken() + " " + rev;
        }

        StringTokenizer str = new StringTokenizer(rev);

        while (str.hasMoreTokens()){
            // store the current token inside the cur variable
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
                    String s = "(" + op1 + "*" + op2 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(product));
                }
                else if (cur.equals("/")){
                    int div = operand1 / operand2;
                    String s = "(" + op1 + "/" + op2 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(div));
                }
                else if (cur.equals("-")){
                    int diff = operand1 - operand2;
                    String s = "(" + op1 + "-" + op2 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(diff));
                }
                else if (cur.equals("+")){
                    int sum = operand1 + operand2;
                    String s = "(" + op1 + "+" + op2 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(sum));
                }
                else {
                    int power = (int) Math.pow(operand1, operand2);
                    String s = "(" + op1 + "^" + op2 + ")";
                    infix.push(s);
                    stack.push(Integer.toString(power));
                }
            }
            else {
                stack.push(cur);
                infix.push(cur);
            }
        }

        System.out.println(infix.pop());

        // return the only stack content by popping out the value
        return Integer.parseInt(stack.pop());
    }
    public static void main(String[] args) throws StackUnderflowed, StackOverflowed{
        System.out.println(evaluatePrefixExp("- * 12 5 + 40 / 100 4"));
    }
}