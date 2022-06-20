class Solution {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> hs=new HashSet(Arrays.asList(words));
        
        for(String s: words){
            for(int i=1;i<s.length();i++){
                hs.remove(s.substring(i));
            }
        }
        int ans=0;
        for(String word : hs){
            ans+=word.length()+1;
        }
        
        return ans;
    }
}