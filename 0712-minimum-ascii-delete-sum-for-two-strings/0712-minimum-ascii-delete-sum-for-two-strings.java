class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, s1, s2, dp);
    }
    
    int solve(int idx1, int idx2, String s, String t, int[][] dp){
        int m = s.length(), n = t.length();
        if(idx1 == m && idx2 == n) return 0;
        if(idx2 == n){
            int sum = 0;
            while(idx1 < m){
                sum += s.charAt(idx1++);
            }
            return sum;
        }
        if(idx1 == m){
            int sum = 0;
            while(idx2 < n){
                sum += t.charAt(idx2++);
            }
            return sum;
        }
        
        if(dp[idx1][idx2] != -1) return dp[idx1][idx2];
        int pick = 0;
        if(s.charAt(idx1) == t.charAt(idx2)){
            pick = solve(idx1 + 1, idx2 + 1, s, t, dp);
            return dp[idx1][idx2] = pick;
        }
        
        int notpick1 = solve(idx1 + 1, idx2, s, t, dp) + (int)s.charAt(idx1);
        int notpick2 = solve(idx1, idx2 + 1, s, t, dp) + (int)t.charAt(idx2);
        
        return dp[idx1][idx2] = Math.min(notpick1, notpick2);
    }
}