package POTD;

public class LC1304 {
    public int[] sumZero(int n) {
        int[] arr = new int[n];

        if (n == 1) {
            arr[0] = 0;
        }
        else {
            int value = n/2;

            if (n%2 == 1)
                n--;

            for (int i=0; i<n; i+=2) {
                arr[i] = value;
                arr[i+1] = -value;
                value++;
            }
        }

        return arr;
    }
}
