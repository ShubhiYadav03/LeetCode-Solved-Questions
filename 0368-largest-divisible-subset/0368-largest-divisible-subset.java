class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        int n = arr.length;
        
        int[] dp = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(arr);
        int idx = 0, max = dp[0];
        for(int i = 1; i < n; i++){
            prev[i] = i;
            for(int j = 0; j < i; j++){
                if(arr[j] % arr[i] == 0 || arr[i] % arr[j] == 0){
                    if(dp[i] < 1 + dp[j]){
                        dp[i] = 1 + dp[j];
                        prev[i] = j;
                    }
                }
                if(dp[i] > max){
                    max = dp[i];
                    idx = i;
                }
            } 
        }
       

        List<Integer> ans = new ArrayList<>();
        ans.add(arr[idx]);
        while(idx != prev[idx]){
            idx = prev[idx];
            ans.add(0, arr[idx]);
        }
        return ans;
    }
}