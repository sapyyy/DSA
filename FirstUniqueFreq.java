public class FirstUniqueFreq {
    public int firstUniqueFreq(int[] nums) {
        // map to count the freq of each ele
        Map <Integer, Integer> map = new HashMap <> ();
        for (int ele : nums) 
            map.put(ele, map.getOrDefault(ele, 0) + 1);

        // map to count the freq of the freqs
        Map <Integer, Integer> map2 = new HashMap <> ();
        for (int val : map.values()) 
            map2.put(val, map2.getOrDefault(val, 0) + 1);

        for (int ele : nums) {
            if (map2.get(map.get(ele)) == 1) {
                return ele;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        
    }
}
