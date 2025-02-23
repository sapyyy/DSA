public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices){
        int len = prices.length;
        int minEle = Integer.MAX_VALUE;
        int profitMax = 0;

        for (int i=0; i<len; i++){
            minEle = Math.min(minEle, prices[i]);
            profitMax = Math.max(profitMax, prices[i] - minEle);
        }

        return profitMax;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,4,1}));
    }
}
