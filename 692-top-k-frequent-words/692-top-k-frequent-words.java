class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList();
        for(String word : words){
            if(map.containsKey(word)) map.put(word, map.get(word) + 1);
            else map.put(word, 1);
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>(words.length, (a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        for (Map.Entry<String, Integer> it: map.entrySet()){
            pq.add(it.getKey());
        }
        
        while(!pq.isEmpty() && k > 0){
            list.add(pq.poll());
            k--;
        }
        
        return list;
    }
}