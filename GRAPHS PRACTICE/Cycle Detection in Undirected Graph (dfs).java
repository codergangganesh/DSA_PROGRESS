class Solution {
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean vis[] , int start)
    {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start,-1});
        vis[start]=true;
        while(!q.isEmpty())
        {
             int[] x = q.poll();
            int node =x[0];
            int parent=x[1];
            for(int neighbor:adj.get(node))
            {
                if(!vis[neighbor]) 
                {
                    vis[neighbor]= true;
                    q.add(new int[]{neighbor,node});
                }
                else
                {
                    if(neighbor!=parent)
                    {
                      return true;  
                    }
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for (int i=1;i<=V;i++)
         {
             adj.add(new ArrayList<>());
         }
         for(int[] edge : edges)
         {
             adj.get(edge[0]).add(edge[1]);
             adj.get(edge[1]).add(edge[0]);
         }
         boolean vis[] = new boolean[V];
         for(int i=0;i<V;i++)
         {
             if(!vis[i])
             {
                 if(bfs(adj,vis,i))
                    return true;
             }
         }
         return false;
         
    }
}