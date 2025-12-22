class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int[] visited,int[] pathVisited, int v)
    {
        
        visited[v] = 1;
        pathVisited[v] = 1;
        for(int x:adj.get(v))
        {
            if(pathVisited[x] == 1)
                return true;
            if (visited[x] ==0 && dfs(adj,visited,pathVisited,x))
                return true;
        }
        pathVisited[v] = 0;
        return false;
    }
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] visited =new int[V];
        int[] pathVisited =new int[V];
    
        for (int i=0;i<V;i++)
        {
            if (visited[i] == 0)
            {
                if (dfs(adj, visited, pathVisited, i))
                    return true;
            }
        }
        return false;
}
}
