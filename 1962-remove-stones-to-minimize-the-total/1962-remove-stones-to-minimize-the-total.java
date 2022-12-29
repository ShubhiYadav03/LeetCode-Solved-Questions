class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        int sum = 0;
        for(int n : piles){
           pq.add(n);
        }
        while(k > 0){
            int max = pq.remove();
            max = (max%2 == 0) ? max/2 : max/2 + 1;
            pq.add(max);
            k--;
        }
        while(!pq.isEmpty()){
            sum += pq.remove(); 
        }
        return sum;
    }
}