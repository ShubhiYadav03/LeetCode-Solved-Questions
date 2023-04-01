class Solution {
    public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        int m = s.length(), n = p.length();
        int[][] dp = new int[m + 1][n + 1];
        
        dp[0][0] = 1;
        int i = 1;
        while(i < n && p.charAt(i) == '*'){
            dp[0][i + 1] = 1;
            i += 2; 
        }
        
        for(int idx1 = 1; idx1 <= m; idx1++){
            for(int idx2 = 1; idx2 <= n; idx2++){
        
                if(s.charAt(idx1 - 1) == p.charAt(idx2 - 1) || p.charAt(idx2 - 1) == '.'){
                    int pick = dp[idx1 - 1][idx2 - 1];
                    dp[idx1][idx2] = pick;
                }
    
                else if(s.charAt(idx1 - 1) != p.charAt(idx2 - 1) && p.charAt(idx2 - 1) == '*'){
                    int pick = 0;
                    if(s.charAt(idx1 - 1) == p.charAt(idx2 - 2) || p.charAt(idx2 - 2) == '.'){
                        pick = (dp[idx1 - 1][idx2] == 1) ? 1 : dp[idx1][idx2 - 1];
                    }
                        int notpick = (idx2 - 2 >= 0) ? dp[idx1][idx2 - 2] : 0;
                        dp[idx1][idx2] = (notpick + pick > 0) ? 1 : 0;
                }
                else dp[idx1][idx2] = 0;
            }
        }
        return dp[m][n] == 1;
    }
}
