class Solution {
    public boolean canConstruct(String ransom, String magazine) {
        if(ransom.length() > magazine.length()) 
            return false;
        if(ransom.length() == magazine.length() && ransom.equals(magazine)) 
            return true;
            
        
        HashMap<Character, Integer> hm = new HashMap();
        
        for(char ch : magazine.toCharArray()){
            if(hm.containsKey(ch)) hm.put(ch, hm.get(ch) + 1);
            else hm.put(ch, 1);
        }
        
        for(char ch : ransom.toCharArray()){
            if(!hm.containsKey(ch)) return false;
            else hm.put(ch, hm.get(ch) - 1);
            
            if(hm.get(ch) == 0) hm.remove(ch);
        }
        
        return true;
    }
}