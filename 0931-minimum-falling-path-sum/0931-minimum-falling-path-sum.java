class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i = matrix.length - 2; i >= 0 ; i--){
            for(int j = 0; j < matrix[0].length; j++){
                int min = Integer.MAX_VALUE;
                if(j > 0 && j < matrix.length - 1) min = Math.min(matrix[i + 1][j + 1], Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]));
                else if(j > 0) min = Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                else if(j < matrix.length - 1) min = Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                
                matrix[i][j] += min;
            }
        }
        int ans = matrix[0][0];
        for(int i = 1; i < matrix.length; i++){
            ans = Math.min(ans, matrix[0][i]);
        }
        
        return ans;
    }
}