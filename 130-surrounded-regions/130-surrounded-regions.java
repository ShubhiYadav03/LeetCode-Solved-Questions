class Solution {
    public void solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1) && board[i][j]=='O'){
                    dfs(board,i,j);
                }
            }
        }
            
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='A') board[i][j]='O';                
            }
        }
    }
    
    
    void dfs(char[][] board,int i,int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O') return;
        board[i][j]='A';
        dfs(board,i-1,j);
        dfs(board,i+1,j);
        dfs(board,i,j-1);
        dfs(board,i,j+1);
    }
}

// [["X","O","X","O","X","O"],   ,
//  ["O","X","O","X","O","X"],    
//  ["X","O","X","O","X","O"],    ["X","X","X","O","X","O"],
//  ["O","X","O","X","O","X"]]    ["O","X","O","X","O","X"]]