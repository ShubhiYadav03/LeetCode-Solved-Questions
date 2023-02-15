class Solution {
    List<List<String>> ans = new ArrayList();
    public List<List<String>> solveNQueens(int n) {  
        int[][] board = new int[n][n];
        
        boolean[] queencol = new boolean[n];
        // boolean[] queenrow = new boolean[n];
        dfs(0, board, queencol);
        
        return ans;
    }
    
    void dfs(int row, int[][] board, boolean[] queencol){
        if(row == board.length){
            // System.out.println(Arrays.deepToString(board));
            List<String> list = new ArrayList();
            for(int i = 0; i < board.length; i++){
                String str = "";
                for(int j = 0; j < board.length; j++){
                    if(board[i][j] == 1) str += "Q";
                    if(board[i][j] == 0) str += ".";
                }
                list.add(str);
            }
            ans.add(new ArrayList(list));
            return;
        }
        
        for(int col = 0; col < board.length; col++){
            if(!queencol[col] && queendiag(row, col, board)){
                board[row][col] = 1;
                queencol[col] = true;
                // queenrow[row] = true;
                dfs(row + 1, board, queencol);
                board[row][col] = 0;
                queencol[col] = false;
                // queenrow[row] = false;
            }
        }
        
    }
    
    boolean queendiag(int row, int col, int[][] board){
        int r = row, c = col;
        while(row >= 0 && col >= 0){
            if(board[row][col] == 1){
                return false;
            }
            row--;
            col--;
        }
        
        while(r >= 0 && c < board.length){
            if(board[r][c] == 1){
                return false;
            }
            r--;
            c++;
        }

        
        return true;
    }
}