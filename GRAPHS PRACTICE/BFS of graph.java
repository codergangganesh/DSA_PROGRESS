class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        int v = adj.size();
        boolean isVisited[] = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        isVisited[0] = true;
        
        while (!q.isEmpty()) {
            int x = q.poll();
            ans.add(x);
            
            for (int a : adj.get(x)) {
                if (!isVisited[a]) {
                    q.add(a);
                    isVisited[a] = true;
                }
            }
        }
        return ans;
    }
}
