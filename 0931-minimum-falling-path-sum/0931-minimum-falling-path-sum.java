class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for(int i = matrix.length - 2; i >= 0; i--){
            for(int j = 0; j < matrix[0].length; j++){
                if(j == 0 && j + 1 == matrix[0].length)
                    matrix[i][j] += matrix[i + 1][j];
                else if(j == 0)
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);      
                else if(j + 1 == matrix[0].length)
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j - 1]);
                else
                    matrix[i][j] += Math.min(matrix[i + 1][j], Math.min(matrix[i + 1][j + 1], matrix[i + 1][j - 1]));
            }
        }
        int min = matrix[0][0];
        for(int j = 0; j < matrix[0].length; j++){
            min = Math.min(matrix[0][j], min);
        }
        return min;
    }
}