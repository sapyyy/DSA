package StackAssignment;

/*2. Write a method in a separate class to check an expression is valid or not. */

public class ValidExpression {
    static boolean checkValidExpression(String exp) throws StackOverflowed, StackUnderflowed{

        int len = exp.length();
        MyStack <Character> opening = new MyStack <> (len);

        int i = 0;
        while(i < len){
            // copying the cur char in c
            char c = exp.charAt(i);
            String brackets = "({[)}]";

            if (!brackets.contains(Character.toString(c))) {
                i++;
                continue;
            }

            // if the char is opening bracket push it to the stack
            if (c == '(' || c == '{' || c == '['){
                opening.push(c);
            }
            else {
                // popped to store the popped element
                if (opening.isEmpty()){
                    return false;
                }
                
                char poppedEle = opening.pop();
                
                // check whether the popped one has matching brackets
                if (poppedEle == '(' && c != ')' ||
                    poppedEle == '{' && c != '}' ||
                    poppedEle == '[' && c != ']'){
                        return false;
                    }
            }

            i++;
        }
        
        // if the opening stack is not empty we have an invalid expression
        if (opening.peek() != null){
            return false;
        }

        return true;
    }
    public static void main(String[] args) throws StackOverflowed,StackUnderflowed {
        String expression = "(((a+(b*c))-(d/e))+((f-g)*(h+(i/j))))";
        System.out.println(checkValidExpression(expression));
    }
}
