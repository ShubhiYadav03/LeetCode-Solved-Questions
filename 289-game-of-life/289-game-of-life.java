class Solution {
    public void gameOfLife(int[][] board) {
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                int neighbours= countNeighbours(board,i,j);
                if(board[i][j]==1){
                if(neighbours==2||neighbours==3) board[i][j]=3;
                    }else{
                    if(neighbours==3) board[i][j]=2;
                }
            }
        }
        
         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]<2) board[i][j]=0;
                else board[i][j]=1;
            }
        }
        
        
    }
    
    int countNeighbours(int[][] board, int r, int c){
        int count =0;
     for(int i=r-1;i<=r+1;i++){
       for(int j=c-1;j<=c+1;j++){
           if(i<0||j<0||i==board.length||j==board[0].length|| (i==r&&j==c)) continue;
           if(board[i][j]==1||board[i][j]==3) count++;
       }  
     }
        return count;
    }
}