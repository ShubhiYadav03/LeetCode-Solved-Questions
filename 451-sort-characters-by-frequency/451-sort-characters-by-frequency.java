class Solution {
    public String frequencySort(String s) {
        // PriorityQueue<Pair<Integer,Integer>> pq=new Pair(Collections.reverseOrder());
        Map<Character,Integer> hm=new HashMap();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))) hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            else hm.put(s.charAt(i),1);
        }
        
        ArrayList<Map.Entry<Character, Integer>> list=new ArrayList<>();
        for(Map.Entry<Character, Integer> e: hm.entrySet()) {
            list.add(e);
        }
        
        Collections.sort(list,(a,b)->a.getValue().compareTo(b.getValue()));
        Collections.reverse(list);
        String ans="";
        for(int i=0;i<list.size();i++){
            String c=list.get(i).getKey()+"";
            ans+=c.repeat(list.get(i).getValue());
        }
        
        return ans;
    }
}