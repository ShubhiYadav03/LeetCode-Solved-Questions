class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0],b[0]));
        int idx = 0, max = dp[0];
        for(int i = 1; i < n; i++){

            for(int j = 0; j < i; j++){
                if(pairs[j][1] < pairs[i][0]){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];

                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                }
            } 
        }
       return max;
    }
}