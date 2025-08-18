public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List <List<Integer>> res = new ArrayList <> ();
        // Sort the array 
        // As we need to ignore duplicate combination & prune branches
        Arrays.sort(candidates);
        findUniqueCombination(0, target, candidates, new ArrayList <> (), res);
        return res;
    }

    public void findUniqueCombination(int index, int target, int[] candidates, List <Integer> ds, List <List<Integer>> res) {
        // base case
        if (target == 0) {
            res.add(new ArrayList <> (ds));
            return;
        }

        for (int i=index; i<candidates.length; i++) {
            // if there is similar elements in the array, skip
            if (i > index && candidates[i] == candidates[i - 1]) continue;
            // if the element is greater than target, prune
            if (candidates[i] > target) break;

            ds.add(candidates[i]);
            findUniqueCombination(i+1, target - candidates[i], candidates, ds, res);
            ds.remove(ds.size() - 1);
        }
    }
}
