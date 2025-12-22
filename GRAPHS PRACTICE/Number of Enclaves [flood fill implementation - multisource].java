import java.util.*;

class Solution {

    void bfs(int[][] grid, int sr, int sc, int n, int m) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{ sr, sc });
        grid[sr][sc] = 0;

        int[] row = { -1, 0, 1, 0 };
        int[] col = { 0, -1, 0, 1 };

        while (!q.isEmpty()) {

            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int k = 0; k < 4; k++) {

                int nr = r + row[k];
                int nc = c + col[k];

                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < m &&
                    grid[nr][nc] == 1) {

                    grid[nr][nc] = 0;
                    q.add(new int[]{ nr, nc });
                }
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {

            if (grid[i][0] == 1) {
                bfs(grid, i, 0, n, m);
            }

            if (grid[i][m - 1] == 1) {
                bfs(grid, i, m - 1, n, m);
            }
        }

        for (int j = 0; j < m; j++) {

            if (grid[0][j] == 1) {
                bfs(grid, 0, j, n, m);
            }

            if (grid[n - 1][j] == 1) {
                bfs(grid, n - 1, j, n, m);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
