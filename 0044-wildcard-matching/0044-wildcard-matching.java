class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        int m = s.length(), n = p.length();
        int[][] dp = new int[m][n];
        
        int ans = solve(0, 0, s, p, dp);
        return ans == 1;
    }
    
    int solve(int idx1, int idx2, String s, String p, int[][] dp){
        int m = s.length(), n = p.length();
        if(idx1 == m && idx2 == n) return 1;
        if(idx2 == n) return -1;
        if(idx1 == m){
            while(idx2 < n && p.charAt(idx2) == '*'){
                idx2++;
            }
            
            return (idx2 == n) ? 1 : -1;
        }
        
        if(dp[idx1][idx2] != 0) return dp[idx1][idx2];
        
        char chs = s.charAt(idx1), chp = p.charAt(idx2);
        if(chs == chp || chp == '?'){
            return dp[idx1][idx2] = solve(idx1 + 1, idx2 + 1, s, p, dp);
        }
        
        if(chp == '*'){
            int pick = solve(idx1 + 1, idx2, s, p, dp);
            int notpick = solve(idx1, idx2 + 1, s, p, dp);
            
            return dp[idx1][idx2] = (pick == 1) ? pick : notpick;
        }
        return -1;
    }
}