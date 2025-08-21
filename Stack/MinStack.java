package Stack;

import java.util.*;

class MinStack {
    class Pair <T, I> {
    T val;
    I min;

    Pair (T val, I min) {
        this.val = val;
        this.min = min;
        }
    }

    List <Pair <Integer, Integer>> arr;
    public MinStack() {
        arr = new ArrayList <> ();
    }
    
    public void push(int val) {
        if (arr.size() == 0) {
            arr.add(new Pair <> (val, val));
        }
        else {
            // check the min
            int min = Math.min(val, arr.get(arr.size() - 1).min);
            arr.add(new Pair <> (val, min));
        }
    }
    
    public void pop() {
        arr.remove(arr.size() - 1);        
    }
    
    public int top() {
        return arr.get(arr.size() - 1).val;
    }
    
    public int getMin() {
        return arr.get(arr.size() - 1).min;
    }
}

public class MinStack {
    public static void main(String[] args) {
        
    }
}
