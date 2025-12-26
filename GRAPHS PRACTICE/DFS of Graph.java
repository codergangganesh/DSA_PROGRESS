class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.size()];
        
        dfsUtil(0, adj, isVisited, ans);
        return ans;
    }
    
}
