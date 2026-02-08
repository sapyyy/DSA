public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int totalCount = 0;
        // [1, 2, 3], s=[1, 1, 2, 3, 2, 3, 3]
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;

        while (i < g.length && j < s.length) {
            while (j < s.length && s[j] < g[i]) {
                j++;
            }

            if (j >= s.length) break;
            totalCount++;
            i++;
            j++;
        }

        return totalCount;
    }
}
