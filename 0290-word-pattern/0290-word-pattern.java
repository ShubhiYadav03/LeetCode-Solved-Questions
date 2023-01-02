class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] sarr = s.split(" ");
        if(pattern.length() != sarr.length) return false;
        Set<String> set = new HashSet();
        Map<Character, String> map = new HashMap();
        for(int i = 0; i < pattern.length(); i++){
            if(!map.containsKey(pattern.charAt(i)) && set.contains(sarr[i])){
                return false;
            }
            if(!map.containsKey(pattern.charAt(i))){
                map.put(pattern.charAt(i), sarr[i]);
                set.add(sarr[i]);
            }
            else{
                if(!map.get(pattern.charAt(i)).equals(sarr[i])) return false;          
            }
        }
        
        return true;
    }
}