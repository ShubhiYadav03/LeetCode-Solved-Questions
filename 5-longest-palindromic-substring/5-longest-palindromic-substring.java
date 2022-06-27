class Solution {
    public String longestPalindrome(String s) {
        String res="";
        int ans=0;
        for(int i=0;i<s.length();i++){
            int l=i,r=i;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > ans){
                    ans=Math.max(r-l+1,ans);
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }
            
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                if(r-l+1 > ans){
                    ans=Math.max(r-l+1,ans);
                    res=s.substring(l,r+1);
                }
                l--;
                r++;
            }       
        }
        return res;
    }
}