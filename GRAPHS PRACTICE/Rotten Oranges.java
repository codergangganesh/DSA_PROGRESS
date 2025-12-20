class Solution {
    public int orangesRotting(int[][] A) {
        Queue<int[]> q = new LinkedList<>();
        int m = A.length, n = A[0].length;
        boolean fresh = false;
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) {
                if(A[i][j] == 2) q.add(new int[]{i, j, 0});
                if(A[i][j] == 1) fresh = true;
            }

        if(fresh && q.isEmpty()) return -1;
        int mx = 0;
        int dir[] = new int[]{1, 0, -1, 0, 1};
        while(!q.isEmpty()) {
            int cur[] = q.poll();
            for(int i = 0; i < 4; i++) {
                int x = dir[i] + cur[0], y = dir[i+1] + cur[1];
                if(x < m && y < n && x >= 0 && y >=0 && A[x][y] == 1) {
                    mx = Math.max(mx, cur[2]+1);
                    q.add(new int[]{x, y, cur[2]+1});
                    A[x][y] = 2;
                }
            }
        }
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++) 
                if(A[i][j] == 1) return -1;
        return mx;
    }
}