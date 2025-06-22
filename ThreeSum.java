import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Set <List<Integer>> set = new HashSet <> ();
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n-1; j++) {
                for (int k=j+1; j<n; j++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        List <Integer> arr = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(arr);
                        set.add(arr);
                    }
                }
            }
        }

        return new ArrayList <> (set);
    }

    public static List<List<Integer>> threeSumBetter(int[] nums) {
        int n = nums.length;
        Set <List<Integer>> set = new HashSet <> ();

        for (int i=0; i<n; i++) {
            Set <Integer> hash = new HashSet <> ();
            for (int j=i+1; j<n; j++) {
                int k = -(nums[i] + nums[j]);
                if (hash.contains(k)) {
                    List <Integer> list = Arrays.asList(nums[i], nums[j], k);
                    Collections.sort(list);
                    set.add(list);
                }
                hash.add(nums[j]);
            }
        }

        return new ArrayList <> (set);
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums) {
        int n = nums.length;
        List <List<Integer>> list = new ArrayList <> ();
        Arrays.sort(nums);

        for (int i=0; i<n-2; i++) {
            if (i>0 && nums[i]==nums[i-1]) continue;
            int j = i+1;
            int k = n-1;

            while (j<k) {
                int sum = nums[i]+nums[j]+nums[k];
                if (sum > 0) {
                    k--;
                }
                else if (sum < 0) {
                    j++;
                }
                else {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    int currentJ = nums[j];
                    int currentK = nums[k];
                    while (j < k && nums[j] == currentJ) j++;
                    while (j < k && nums[k] == currentK) k--;
                }
            }
        }

        return list;
    }

    public static void main (String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumBetter(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(threeSumOptimal(new int[]{1,-1,-1,0}));
    }
}

