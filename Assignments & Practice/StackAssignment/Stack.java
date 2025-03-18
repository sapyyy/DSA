package StackAssignment;

// creating an user-defined class to handle the underflow and overflow condition
class StackUnderFlowException extends Exception {
    @Override
    public String toString(){
        return "-x-x-Stack Underflow-x-x-"; 
    }
}

class StackOverFlowException extends Exception {
    @Override
    public String toString(){
        return "-x-x-Stack Overflow-x-x-"; 
    }
}


class MyStack <T> {
    private T[] arr;
    private int maxSize;
    private int top;
    
    @SuppressWarnings("unchecked")
    MyStack(int maxSize){
        this.top = -1;
        this.maxSize = maxSize;
        arr = (T[]) new Object[maxSize];
    }

    public void push(T ele){
        try{
            // if the top is less than the max size then we consider to push elements
            if (top < maxSize - 1){
                arr[++top] = ele;
            } 
            // else we know the stack will hit the maxsize, throwing overflow!
            else {
                throw new StackOverFlowException();
            }
        } catch (StackOverFlowException e){
            e.printStackTrace();
        }
    }

    public T pop(){
        // storing the null value as it is raw type
        T ele = null;

        try{
            // if the the top is greater than -1 we can pop 
            if (top > -1){
                ele = arr[top--];
                return ele;
            }
            // else we throw underflow error
            else {
                throw new StackUnderFlowException();
            }
        } catch (StackUnderFlowException e) {
            e.printStackTrace();
        }

        // finally returning the null value, if there is nothing to return
        return ele;
    }

    public T peek(){
        T ele = null;

        
        try{
            // if the the top is greater than -1 we can peek 
            if (top > -1){
                ele = arr[top];
                return ele;
            }
            // else we throw underflow error
            else {
                throw new StackUnderFlowException();
            }
        } catch (StackUnderFlowException e) {
            e.printStackTrace();
        }

        // finally returning null value when unable to peek
        return ele;
    }

    public String isFull(){
        return top == maxSize - 1 ? "The current stack is full" : "The current stack is not full";
    }

    public String isEmpty(){
        return top == -1 ? "The current stack is empty" : "The current stack is not empty";
    }
}


public class Stack {
    public static void main(String[] args) {
        MyStack <Integer> stack = new MyStack <> (5);
        System.out.println(stack.isEmpty());
        stack.push(35);
        stack.push(45);
        stack.push(39);
        stack.push(54);
        stack.push(343);
        
        // this should generate an overflow exception
        stack.push(34);
        System.out.println(stack.isFull());

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        
        // must result in underflow
        System.out.println(stack.pop());
    }
}
