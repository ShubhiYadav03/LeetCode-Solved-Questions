class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length(), n = str2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for(int idx1 = m - 1; idx1 >= 0; idx1--){
            for(int idx2 = n - 1; idx2 >= 0; idx2--){
                int equal = 0;
                if(str1.charAt(idx1) == str2.charAt(idx2))
                    equal = dp[idx1 + 1][idx2 + 1] + 1;
        
                int pick1 = dp[idx1][idx2 + 1];
                int pick2 = dp[idx1 + 1][idx2];
        
                dp[idx1][idx2] = Math.max(equal, Math.max(pick1, pick2));
            }
        }
        
        System.out.println(Arrays.deepToString(dp));
        String ans = "";
        int i = 0, j = 0;
        while(i < m &&  j < n){
            if(str1.charAt(i) == str2.charAt(j)){
                ans += str1.charAt(i);
                i++;
                j++;
            }else{
                if(dp[i + 1][j] >= dp[i][j + 1]){
                    ans += str1.charAt(i);
                    i++;
                }else if(dp[i + 1][j] < dp[i][j + 1]){
                    ans += str2.charAt(j);
                    j++;
                }
                    // else{
                //     // ans += str1.charAt(i);
                //     // ans += str2.charAt(j);
                //     // i++;
                // }
            }
        }
        
        while(i < m){
            ans += str1.charAt(i++);   
        }
        
        while(j < n){
            ans += str2.charAt(j++);   
        }
        
        return ans;
    }
    
}