class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        if(p.length() == 1 && p.charAt(0) == '*') return true;
        int m = s.length(), n = p.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return match(0, 0, s, p, dp);
    }
    
    boolean match(int idx1, int idx2, String s, String p, int[][] dp){
        int m = s.length(), n = p.length();
        if(idx1 == m && idx2 == n) return true;
        if(idx2 == n) return false;
        if(idx1 == m){
            if(p.charAt(idx2) == '*'){
                while(idx2 < n && p.charAt(idx2) == '*'){
                    idx2++;
                }
                
                return idx2 == n;
            }
            return false;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2] == 1;
        
         // pick = false, notpick = false;
        if(s.charAt(idx1) == p.charAt(idx2) || p.charAt(idx2) == '?'){
            boolean pick = match(idx1 + 1, idx2 + 1, s, p, dp);
            dp[idx1][idx2] = (pick) ? 1 : 0;
            return pick;
        }
        else if(s.charAt(idx1) != p.charAt(idx2) && p.charAt(idx2) == '*'){
            
            boolean notpick = match(idx1 + 1, idx2, s, p, dp) || match(idx1 + 1, idx2 + 1, s, p, dp) || match(idx1, idx2 + 1, s, p, dp);
            dp[idx1][idx2] = (notpick) ? 1 : 0;
            return notpick;
        }
        dp[idx1][idx2] = 0;
        return false;
    }
    
}