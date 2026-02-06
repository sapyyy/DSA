public class FractionalKnapsack {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int[][] items = new int[val.length][2];
        
        // storing the weight and values at the 0th and 1th index
        for (int i=0; i<val.length; i++) {
            items[i][0] = wt[i];
            items[i][1] = val[i];
        }
        
        // using comparator to find out the fraction for each weight and value
        Comparator <int[]> comp = (int[] a, int[] b) -> Double.compare((double)b[1]/b[0], (double)a[1]/a[0]);
        Arrays.sort(items, comp);
        
        int curWeight = 0;
        double totalValue = 0.0;
        for (int i=0; i<items.length; i++) {
            if (curWeight == capacity)
                break;
                
            int itemWeight = items[i][0];
            int itemValue = items[i][1];
                
            if (curWeight + itemWeight <= capacity) {
                curWeight += itemWeight;
                totalValue += itemValue;
            }
            else {
                int remain = capacity - curWeight;
                totalValue += ((double)remain/itemWeight) * itemValue;
                curWeight = capacity;
            }
        }
        
        return totalValue;
    }
    public static void main(String[] args) {
        
    }
}
