package StackAssignment;

import java.util.*;

public class InfixToPostfix {
    // compareOperator method to compare two operators and check whether the first's precedence is greater
    private static boolean compareOperator(String op1, String op2){
        Map <String, Integer> p = new HashMap <> ();
        p.put("/", 2);
        p.put("*", 2);
        p.put("+", 1);
        p.put("-", 1);

        // checks if the first operator is greater than the second one
        return p.get(op1) >= p.get(op2);
    } 

    // method to convert the infix expression to postfix
    public static String infixToPostfix(String exp) throws StackUnderflowed, StackOverflowed{
        String postfix = "";
        String operators = "^*/+-";

        StringTokenizer str = new StringTokenizer(exp);
        MyStack <String> stack = new MyStack <> (exp.length());

        while (str.hasMoreTokens()){
            String curToken = str.nextToken();

            // if the current token is operator then push into the stack by checking the precedence
            if (operators.contains(curToken)){
                if (stack.isEmpty()){
                    stack.push(curToken);
                }
                else {
                    String operator1 = stack.peek();

                    // if the last operator in the stack has higher precedence than the current operator
                    // then only we push the curToken to the stack
                    if (operator1.equals("(")){
                        stack.push(curToken);
                    }
                    else if (compareOperator(operator1, curToken)){
                        stack.push(curToken);
                    }
                    else {
                        // just add the last operator from the stack to the postfix expression
                        postfix += stack.pop() + " ";
                    }
                }
            }
            else if (curToken.equals("(") || curToken.equals(")")){
                if (curToken.equals("(")){
                    stack.push(curToken);
                }
                else {
                    while (!stack.isEmpty()){
                        String strTemp = stack.pop();
                        if (strTemp.equals("(")){
                            break;
                        }
                        else
                            postfix += strTemp;
                    }
                }
            }
            else{
                postfix += curToken + " ";
            }
        }

        while (!stack.isEmpty()){
            postfix += stack.pop() + " ";
        }

        return postfix;
    }
    public static void main(String[] args) throws StackUnderflowed, StackOverflowed {
        System.out.println(infixToPostfix("2 + 4 * 55 + ( 99 + 18 )"));;
    }
}
