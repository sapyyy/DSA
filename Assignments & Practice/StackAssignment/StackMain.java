package StackAssignment;

class StackOverflowed extends Exception {
    @Override
    public String toString(){
        return "- X - X - Stack Overflow - X - X -";
    }
}

class StackUnderflowed extends Exception {
    @Override
    public String toString(){
        return "- X - X - Stack Underflow - X - X -";
    }
}

class MyStack <T> {
    // private instance variables
    private int top;
    private T[] arr;
    private int maxSize;

    @SuppressWarnings("unchecked")
    MyStack(int size){
        maxSize = size;
        top = -1;
        arr = (T[]) new Object[maxSize];
    }

    // method to check whether the stack is full or not 
    public boolean isFull(){
        return top == maxSize - 1;
    }

    // method to check whether the stack is empty or not 
    public boolean isEmpty(){
        return top == -1;
    }

    // method to push elements into the stack
    public void push(T ele) throws StackOverflowed {
        if (isFull()){
            throw new StackOverflowed();
        }
        
        arr[++top] = ele;
    }

    // method to pop elements from the stack 
    public T pop() throws StackUnderflowed {
        if (isEmpty()){
            throw new StackUnderflowed();
        }

        return arr[top--];
    }

    // method to see the the top element in the stack
    public T peek() throws StackUnderflowed {
        if (isEmpty()){
            return null;
        }

        return arr[top];
    }
}

public class StackMain {
    public static void main(String[] args) {
        MyStack <Integer> stack = new MyStack <> (5);
        
        // pushing elements into the stack here
        try {
            stack.push(10);
            stack.push(1);
            stack.push(30);
            stack.push(50);
            stack.push(60);
            stack.push(60);
        } catch (StackOverflowed e){
            e.printStackTrace();
        }
        
        System.out.println(stack.isFull());
        // poppin elements into the stack here
        try {
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.peek());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());
        } catch (StackUnderflowed e) {
            e.printStackTrace();
        }
    }
}
