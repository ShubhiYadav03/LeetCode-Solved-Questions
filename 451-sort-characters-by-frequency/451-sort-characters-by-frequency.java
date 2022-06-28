class Solution {
    public String frequencySort(String s) {
        String result = "";
Map<Character,Integer> map = new HashMap<>();
for(char c : s.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);

    PriorityQueue<Character> pq = new PriorityQueue<>((a,b) -> map.get(b).compareTo(map.get(a)));
    pq.addAll(map.keySet());
    
    while(pq.size() > 0){
        Character ch = pq.poll();
        int a = map.get(ch);
        
        for(int i=0;i<a;i++){
            result += ch;
        }
    }
        return result;
    }
}