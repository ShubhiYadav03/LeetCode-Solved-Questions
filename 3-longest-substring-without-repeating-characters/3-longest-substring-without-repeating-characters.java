class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs=new HashSet<>();
        int l=0,r=0,max=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            if(!hs.contains(ch)){
                hs.add(ch);
                r++;        
            } else{
                hs.remove(s.charAt(l));
                l++;       
                }
              max=Math.max(hs.size(),max);       
            }
            
           // maxSub=Math.max(max,maxSub);
        return max;
    }
}