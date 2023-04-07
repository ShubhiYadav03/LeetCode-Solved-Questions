class Solution {
    public int findNumberOfLIS(int[] arr) {
        int n = arr.length;
        
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int idx = 0, max = dp[0];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        count[i] = count[j]; 
                    }else if(dp[i] == 1 + dp[j]){
                        count[i] += count[j]; 
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            } 
        }
       
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(dp[i] == max) ans += count[i];
        }
        
        return ans;
        
    }
}