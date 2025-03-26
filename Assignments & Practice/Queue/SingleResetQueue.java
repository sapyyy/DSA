package Queue;

class ResetQueue <T> {
    private int front;
    private int rear;
    private int maxSize;
    private T[] arr;

    @SuppressWarnings("unchecked")
    ResetQueue(int size) {
        maxSize = size;
        front = rear = -1;
        arr = (T[]) new Object[maxSize];
    }

    
}

public class SingleResetQueue {
    public static void main(String[] args) {
        
    }
}
