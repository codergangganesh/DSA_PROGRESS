class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i:nums)
            freq.put(i,freq.getOrDefault(i,0)+1);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for (Map.Entry<Integer,Integer> f : freq.entrySet()){
            pq.add(new int[]{f.getKey(),f.getValue()});
            if(pq.size()>k)
                pq.poll();
        }
        int ans[] = new int[k];
        int i=0;
        while (!pq.isEmpty())
            ans[i++]=pq.poll()[0];
        return ans;
    }
}