class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0) + 1); 
        }
        
        for (Map.Entry<String, Integer> it: map.entrySet()){
            list.add(it.getKey());
        }
        
        Collections.sort(list, (a, b) -> map.get(b) == map.get(a) ? a.compareTo(b) : map.get(b) - map.get(a));
        
        return list.subList(0, k);
    }
}