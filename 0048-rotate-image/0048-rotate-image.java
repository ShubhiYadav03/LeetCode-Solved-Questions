class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reverse(matrix);
    }
    void transpose(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = row; col < matrix[0].length; col++){
                swap(row, col, col, row, matrix);
            }   
        }
    }
    
    void reverse(int[][] matrix){
        for(int row = 0; row < matrix.length; row++){
            for(int col = 0; col < matrix[0].length/2; col++){
                swap(row, col, row, matrix[0].length - col - 1, matrix);
            }   
        }
    }
    
    void swap(int r1, int c1, int r2, int c2, int[][] matrix){
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}