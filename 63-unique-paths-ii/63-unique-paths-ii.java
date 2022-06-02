class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1) return 0;
        int[][] dp=new int[obstacleGrid.length+1][obstacleGrid[0].length+1];
        
        for(int i=dp.length-2;i>=0;i--){
            for(int j=dp[0].length-2;j>=0;j--){
                if(obstacleGrid[i][j]==1){
                    dp[i][j]=0;
                    continue;
                }
                if(i==dp.length-2&&j==dp[0].length-2) dp[i][j]=1;
                else{
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];
    }
}