import java.util.*;

public class RatInAMaze {
    // Function to find all possible paths
    public static ArrayList<String> ratInMaze(int[][] grid) {
         ArrayList <String> res = new ArrayList <> ();
        if (grid[0][0] == 1) {
            dfs(0, 0, grid.length, new boolean[grid.length][grid[0].length], new StringBuilder(), res, grid);
        }
        Collections.sort(res);
        return res;
    }
    
    public static void dfs(int i, int j, int n, boolean[][] visited, StringBuilder ds, List <String> res, int[][] grid) {
        // base case 
        if (i == n-1 && j == n-1) {
            res.add(new String(ds));
        }

        visited[i][j] = true;
        // check which direction to go
        // top direction
        if (i > 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            ds.append("U");
            dfs(i - 1, j, n, visited, ds, res, grid);
            ds.deleteCharAt(ds.length() - 1);
        } 

        // down direction
        if (i < n - 1 && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            ds.append("D");
            dfs(i + 1, j, n, visited, ds, res, grid);
            ds.deleteCharAt(ds.length() - 1);
        }

        // left direction
        if (j > 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            ds.append("L");
            dfs(i, j - 1, n, visited, ds, res, grid);
            ds.deleteCharAt(ds.length() - 1);
        }

        // right direction
        if (j < n - 1 && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            ds.append("R");
            dfs(i, j + 1, n, visited, ds, res, grid);
            ds.deleteCharAt(ds.length() - 1);
        }

        visited[i][j] = false;
    }
    public static void main(String[] args) {
        System.out.println(ratInMaze(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}