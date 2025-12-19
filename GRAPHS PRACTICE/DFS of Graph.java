class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.size()];
        
        dfsUtil(0, adj, isVisited, ans);
        return ans;
    }
    private void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj,boolean[] isVisited, ArrayList<Integer> ans) {
        isVisited[node] = true;
        ans.add(node);
        
        for (int a : adj.get(node)) {
            if (!isVisited[a]) {
                dfsUtil(a, adj, isVisited, ans);
            }
        }
    }
}
