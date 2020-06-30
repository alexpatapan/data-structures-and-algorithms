import javafx.util.Pair;

import java.io.*;
import java.util.*;

class Solution {

    static int currentShortest;


    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        // your code goes here


        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        currentShortest = Integer.MAX_VALUE;

        bfs(grid, sr, sc, new HashSet<>(), 0, tr, tc, directions);

        if (currentShortest == Integer.MAX_VALUE) {
            return -1;
        }
        return currentShortest;
    }

    public static void bfs(int[][] grid, int currentr, int currentc, HashSet<Pair<Integer, Integer>> visited, int currentPath, int tr, int tc, int[][] directions) {

        for (int i = 0; i < directions.length; i++) {
            int a = currentr + directions[i][0];
            int b = currentc + directions[i][1];

            if (a >= grid.length || a < 0 || b >= grid[a].length ||  b < 0 || visited.contains(new Pair(a, b)) || grid[a][b] == 0) continue;

            if (a == tr && b == tc) {
                currentShortest = Math.min(currentPath + 1, currentShortest);
            }

            visited.add(new Pair(a, b));
            bfs(grid, a, b, visited, currentPath + 1, tr, tc, directions);
            visited.remove(new Pair(a, b));

        }

    }

    public static void main(String[] args) {

    }
}
