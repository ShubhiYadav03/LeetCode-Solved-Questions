class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        int[] dp = new int[n];
   
        for(int i = 1; i <= 26; i++){
            set.add(i + "");
        }
        
        return solve(0, s, set, dp);
    }
    
    int solve(int idx, String s, Set<String> set, int[] dp){
        int n = s.length();
        if(idx == n) return 1;
        
        if(dp[idx] != 0) return dp[idx];
        int pick1 = 0;
        if(s.charAt(idx) != '0') pick1 = solve(idx + 1, s, set, dp);
        
        int pick2 = 0;
        if(idx + 1 < n && set.contains(s.substring(idx, idx + 2))){
            pick2 = solve(idx + 2, s, set, dp);
        }
        
        return dp[idx] = pick1 + pick2;
    }
}