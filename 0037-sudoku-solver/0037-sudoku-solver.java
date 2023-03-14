class Solution {
    public void solveSudoku(char[][] board) {
       solve(board);
       // return board; 
        
        // return board;
    }
    
    public boolean solve(char[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(int n = 1; n <= 9; n++){
                        if(isSafe(n, i, j, board)){
                            board[i][j] = (char)(n + '0');
                            if(solve(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
        // return board;
    }
    
//     boolean dfs(int i, int j, char[][] board){
//         if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != '.'){
//             return true;
//         }
        
//         for(int n = 1; n <= 9; n++){
//             if(isSafe(n, i, j, board)){
//                 board[i][j] = (char)(n + '0');
//                 boolean top = dfs(i + 1, j, board);
// //                 boolean bottom = dfs(i - 1, j, board);
// //                 boolean right = dfs(i, j + 1, board);
// //                 boolean left = dfs(i, j - 1, board);
                
// //                 if(top && bottom && right && left) return true;
//                 if(top) return true;
//                 board[i][j] = '.';
//             }
//         }
//         return false;
//     }
    
    boolean isSafe(int n, int row, int col, char[][] board){
        char num = (char)(n + '0');
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == num) return false;
        }
        
        for(int i = 0; i < board[0].length; i++){
            if(board[row][i] == num) return false;
        }
        
        for(int i = (row/3)*3; i < (row/3)*3 + 3; i++){
            for(int j = (col/3)*3; j < (col/3)*3 + 3; j++){
                if(board[i][j] == num) return false;
            }
        }
        
        return true;
    }
}