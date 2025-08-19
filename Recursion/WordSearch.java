package Recursion;

import java.util.*;

public class WordSearch {
     public static boolean exist(char[][] board, String word) {
        boolean exist = false;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    exist = validWordSearch(i, j, 0, board, word, new boolean[board.length][board[0].length]);
                }

                if (exist) return true;
            }
        }

        return exist;
    }

    public static boolean validWordSearch(int i, int j, int index, char[][] board, String word, boolean[][] visited) {
        // base condition
        if (index == word.length()) {
            return true;
        }

        // check if indexes are invalid
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;
        if (validWordSearch(i+1, j, index+1, board, word, visited) ||
            validWordSearch(i-1, j, index+1, board, word, visited) ||
            validWordSearch(i, j+1, index+1, board, word, visited) ||
            validWordSearch(i, j-1, index+1, board, word, visited))
                return true;

        visited[i][j] = false;
        return false;
    }
    
    public static void main(String[] args) {
        boolean ans = exist(new char[][]{{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}}, "SEE");
        System.out.println(ans);
    }
}
