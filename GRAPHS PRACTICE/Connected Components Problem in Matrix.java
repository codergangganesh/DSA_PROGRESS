import java.util.*;

class Solution {
    
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        boolean[] visited = new boolean[V];
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                ArrayList<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);
                result.add(component);
            }
        }
        
        return result;
    }
    
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj,
                     boolean[] visited, ArrayList<Integer> component) {
        visited[node] = true;
        component.add(node);
        
        for (int nbr : adj.get(node)) {
            if (!visited[nbr]) {
                dfs(nbr, adj, visited, component);
            }
        }
    }
}
