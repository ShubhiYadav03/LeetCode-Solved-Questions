class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue( Collections.reverseOrder());
        
        for(int wt : stones){
            pq.add(wt);
        }
        
        while(pq.size() > 1){
            int y = pq.poll();
            int x = pq.poll();
            
            if(y - x > 0) pq.add(y - x);
        }
        
        return (!pq.isEmpty()) ? pq.poll() : 0;
    }
}