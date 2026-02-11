public class MinNoOfCoins {
    public int findMin(int n) {
        int[] coins = {1, 2, 5, 10};
        
        int noOfCoins = 0;
        int curAmount = n;
        for (int i=coins.length - 1; i>=0; i--) {
            int coin = coins[i];

            if (coin > curAmount) continue;
            
            noOfCoins += curAmount / coin;
            curAmount = curAmount % coin;
            if (curAmount == 0) return noOfCoins;
        }
        
        return curAmount > 0 ? -1 : curAmount;
    }
}
}
