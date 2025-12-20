class Solution {
    public void bfs(int[][] isConnected,  boolean vis[], int v)
    {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        vis[v] = true;
        while(!q.isEmpty())
        {
            int x = q.poll();
            for (int i=0;i<isConnected.length;i++ )
            {
                if(isConnected[x][i]==1 && !vis[i])
                {
                    q.add(i);
                    vis[i] = true;

                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        boolean vis[] = new boolean[isConnected.length];
        int provinces=0;
        for(int v=0;v<isConnected.length;v++){
            if(!vis[v])
            {
                provinces++;
                bfs(isConnected,vis,v);
            }
        }
        return provinces;
    }
}