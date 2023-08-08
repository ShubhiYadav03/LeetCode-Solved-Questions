class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3) return 0;
        int ans = 0, j = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++){
            char chi = s.charAt(i);
            map.put(chi, map.getOrDefault(chi, 0) + 1);
            
            if(i - j + 1 == 3){
                if(map.size() == 3)
                    ans++;
                
                char ch = s.charAt(j);
                map.put(ch, map.get(ch) - 1);
                if(map.get(ch) == 0) map.remove(ch);
                j++;    
            }
        }
        return ans;
    }
}