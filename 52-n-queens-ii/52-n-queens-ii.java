class Solution {
    public int totalNQueens(int n) {
      List<List<String>> list=new ArrayList<>();
        boolean[][] board=new boolean[n][n];
        queens(board,0,list);

        
        return list.size();
    }
    
    void queens(boolean[][] board,int row, List<List<String>> list){
        if(row==board.length) {
            List<String> li=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                String s="";
            for(int j=0;j<board.length;j++){
                if(board[i][j]) s+="Q";
                else s+=".";
            }
            li.add(s);
        }
            list.add(li);
        }
        
        for(int col=0;col<board.length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                queens(board,row+1,list);
                board[row][col]=false;
            }
        }
    }
    
    boolean isSafe(boolean[][] board, int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]) return false;
        }
        
         for(int i=1;i<=Math.min(row,col);i++){
            if(board[row-i][col-i]) return false;
        }
        
         for(int i=1;i<=Math.min(row,board.length-col-1);i++){
            if(board[row-i][col+i]) return false;
        }
        
        return true;
    }
}