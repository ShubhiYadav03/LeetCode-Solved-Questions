class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return ways(n - 1, s, dp);
    }
    
    int ways(int idx, String s, int[] dp){
        int n = s.length();
        if(idx < 0) return 1;
        
        if(dp[idx] != -1) return dp[idx];
        int pick = 0;
        if(s.charAt(idx) != '0')
            pick = ways(idx - 1, s, dp);
        int pick2 = 0;
        if(idx > 0 && s.charAt(idx - 1) != '0' && Integer.parseInt(s.charAt(idx - 1) +""+ s.charAt(idx)) <= 26){
            pick2 = ways(idx - 2, s, dp);
        }
        
        return dp[idx] = pick + pick2;
    }
    
}