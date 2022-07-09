

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()) return false;
        if(s1.length() == 0 && s2.length() == 0 && s3.length() == 0) return true;
        
        HashMap<String, Boolean> hm = new HashMap();
        
        return dfs(0, 0, s1, s2, s3, hm);
    }
    
    public boolean dfs(int i, int j, String s1, String s2, String s3, HashMap<String, Boolean> hm){
        if(i == s1.length() && j == s2.length()) return true;
    
        if(hm.containsKey(i + "" + j)) return hm.get(i + "" + j);
        
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i + j) && dfs(i + 1, j, s1, s2, s3, hm)) return true;
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i + j) && dfs(i, j + 1, s1, s2, s3, hm)) return true;
        
        hm.put(i + "" + j, false);
        
        return false;
    }
}