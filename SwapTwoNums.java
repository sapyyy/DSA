import java.util.concurrent.atomic.AtomicInteger;

public class swapTwoNums {
    public static void swap(Integer a, Integer b) {
        a = a ^ b;
        b = b ^ a;
        a = a ^ b;
    }

    public static void swapVals(AtomicInteger a, AtomicInteger b) {
        a.set(a.get() ^ b.get());
        b.set(b.get() ^ a.get());
        a.set(a.get() ^ b.get());
    }

    public static void main(String[] args) {
        Integer a = 43;
        Integer b = 33;

        swap(a, b);
        System.out.println(a + " " + b); // Output: 43 33 (unchanged)

        // Workaround with AtomicInteger
        AtomicInteger a1 = new AtomicInteger(34);
        AtomicInteger b1 = new AtomicInteger(83);

        swapVals(a1, b1);
        System.out.println(a1 + " " + b1); // Output: 83 34 (swapped)
    }
}
