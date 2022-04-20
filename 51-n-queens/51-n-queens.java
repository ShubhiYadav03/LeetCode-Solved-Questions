class Solution {
public List<List<String>> solveNQueens(int n) {
        List<List<String>> rst = new LinkedList<>();
        int[][] matrix = new int[n][n];
        helper(matrix, n, 0, rst);        
        return rst;
    }
    void helper(int[][] matrix, int n, int row, List<List<String>> rst) {
        if (row == n) {
            formQueenString(matrix, rst);
            return ;
        }
        // I am putting queen from top row to bottom row
        // in each row, I could put queen in n # of col position. This is my choices, like loop n-ary tree
        for (int col = 0; col < n; col++) {
            if (isValid(matrix, row, col)) {
                matrix[row][col] = 1; // put queen;
                helper(matrix, n, row + 1, rst); // now, I need to put queen in a new row!
                matrix[row][col] = 0; // remove queen
            }            
        }
    }
    boolean isValid(int[][] matrix, int row, int col) {
        // check col
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] == 1) {
                return false;
            }
        }
        // check top left
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        // check top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < matrix.length; i--, j++) {
            if (matrix[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
    // convert matrix to N Queen string
    void formQueenString(int[][] matrix, List<List<String>> rst) {   
        List<String> ls = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();            
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 0) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            ls.add(sb.toString());
        }
        rst.add(ls);
    }
}
