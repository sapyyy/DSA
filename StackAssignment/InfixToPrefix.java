package StackAssignment;

import java.util.*;

public class InfixToPrefix {
    private static boolean compareOperator(String op1, String op2){
        Map <String, Integer> p = new HashMap <> ();
        p.put("/", 2);
        p.put("*", 2);
        p.put("+", 1);
        p.put("-", 1);

        // checks if the first operator is greater than the second one
        return p.get(op1) >= p.get(op2);
    }

    public static String infixToPrefix(String exp) throws StackUnderflowed, StackOverflowed{
        String prefix = "";
        String postfix = "";
        String operators = "*/+-";

        // reversing the expression and replacing the brackets
        StringTokenizer str = new StringTokenizer(exp);
        String revExp = "";
        while (str.hasMoreTokens()){
            String cur = str.nextToken();
            if (cur.equals("(")){
                revExp = ")" + " " + revExp;
            }
            else if (cur.equals(")")){
                revExp = "(" + " " + revExp;
            }
            else {
                revExp = cur + " " + revExp;
            }
        }

        // converting the revExp to postfix
        MyStack <String> stack = new MyStack <> (exp.length());
        StringTokenizer revExp1 = new StringTokenizer(revExp);
        while (revExp1.hasMoreTokens()){
            String curToken = revExp1.nextToken();

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

        // now we reverse the postfix expression to get the prefix expression
        StringTokenizer revExp2 = new StringTokenizer(postfix);

        while (revExp2.hasMoreTokens()){
            String temp = revExp2.nextToken();
            prefix = temp + prefix;
        }

        return prefix;
    }
    public static void main(String[] args) throws StackUnderflowed, StackOverflowed {
        System.out.println(infixToPrefix("2 + 3 + 4 * ( 5 + 0 )"));
    }
}
