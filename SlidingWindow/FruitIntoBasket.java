import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    public int totalFruit(int[] fruits) {
        // bruteforce
        int maxTrees = 0;
        int n = fruits.length;

        for (int i=0; i<n; i++) {
            int fruit1 = fruits[i];
            int fruit2 = -1;
            for (int j=i; j<n; j++) {
                if (fruits[j] != fruit1 && fruits[j] != fruit2) {
                  if (fruit2 == -1) fruit2 = fruits[j];
                  else break;  
                }

                maxTrees = Math.max(maxTrees, j - i + 1);
            }
        }
        
        return maxTrees;
    }
    public int totalFruit1(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        int l = 0;
        int r = 0;
        Map <Integer, Integer> map = new HashMap <> ();
    
        while (r < n) {
            int f = fruits[r];

            while (!map.containsKey(f) && map.size() == 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
                l++;
            }

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            maxFruits = Math.max(maxFruits, r - l + 1);
            r++;
        }

        return maxFruits;
    }
    public static void main(String[] args) {
        
    }
}
