class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> mp=new HashMap();
        
        for(String s:strs){
            char[] ch=s.toCharArray();
            Arrays.sort(ch);
            String str=String.valueOf(ch);
             
            if(mp.containsKey(str)) mp.get(str).add(s);
            else{
                List<String> li=new ArrayList<>();
                li.add(s);
                mp.put(str,li);
            } 
        }
        
        List<List<String>> list=new ArrayList<>();
        for(String key:mp.keySet()){
            list.add(mp.get(key));
        }
        
        return list;
    }
}