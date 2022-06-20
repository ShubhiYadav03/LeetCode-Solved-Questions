class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words,(a,b)->b.length()-a.length());
        StringBuilder ans=new StringBuilder();
        for(String s:words){
            if(ans.indexOf(s+"#")==-1){
                ans.append(s+"#");
            }
        }
        return ans.length();
    }
}