class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        StringBuilder sb = new StringBuilder(s);
        dfs(0, sb, dict);
        
        return ans;
    }
    
    void dfs(int i, StringBuilder sb, Set<String> dict){
        if(i == sb.length()){
            
            String str = new String(sb);
            ans.add(str.substring(0, str.length() - 1));
            return;
        }
        
        for(int j = i + 1; j <= sb.length(); j++){
            if(dict.contains(sb.substring(i,j))){
                sb.insert(j, " ");
                dfs(j + 1, sb, dict);
                sb.deleteCharAt(j);
            }
        }
    }
}