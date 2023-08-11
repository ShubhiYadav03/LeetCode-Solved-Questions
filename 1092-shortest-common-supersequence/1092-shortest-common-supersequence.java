class Solution {
    public String shortestCommonSupersequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int dp[][] = new int[m + 1][n + 1];
        
        for(int idx1 = m - 1; idx1 >= 0; idx1--){
            for(int idx2 = n - 1; idx2 >= 0; idx2--){
                char ch1 = text1.charAt(idx1), ch2 = text2.charAt(idx2);
                int pick = 0;
                if(ch1 == ch2)
                    pick = dp[idx1 + 1][idx2 + 1] + 1;
            
                int notpick1 = dp[idx1 + 1][idx2];
                int notpick2 = dp[idx1][idx2 + 1];

                dp[idx1][idx2] = Math.max(pick, Math.max(notpick1, notpick2));
            }
        }
        
        String ans = "";
        
        int i = 0, j = 0;
        
        while(i < m && j < n){
            if(text1.charAt(i) == text2.charAt(j)){
                ans += text1.charAt(i);
                i++;
                j++;
                continue;
            }
            if(dp[i + 1][j] >= dp[i][j + 1]){
                ans += text1.charAt(i);
                i++;
            }else{
                ans += text2.charAt(j);
                j++;
            }
        }
        
        while(i < m){
            ans += text1.charAt(i++);   
        }
        
        while(j < n){
            ans += text2.charAt(j++);   
        }
        
        return ans;
    }
}