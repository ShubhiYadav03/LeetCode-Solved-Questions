class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))) 
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            else 
                hm.put(s.charAt(i), 1);                                              
        }
        
        int ans = 0;
        for(Character ch : hm.keySet()){
            ans += (hm.get(ch)/2) * 2;
        }
        if(ans != s.length()) ans += 1;
        
        return ans;
    }
}