class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length%groupSize!=0)
            return false;
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int v : hand)
            freq.put(v,freq.getOrDefault(v,0)+1);
        for (int x : freq.keySet())
            pq.add(x);
        while (!pq.isEmpty()){
            int f = pq.peek();
            if (freq.get(f)==0)
                pq.poll();
            else{
                freq.put(f,freq.get(f)-1);
                for (int i=1;i<=groupSize-1;i++){
                    ++f;
                    if (!freq.containsKey(f) || freq.get(f)==0)
                        return false;
                    freq.put(f,freq.get(f)-1);
                    
                }
            }
        }
        return true;
    }
}