class Solution {
    boolean ifexist = false;
    public boolean exist(char[][] board, String word) {
       if(word.length() > board.length * board[0].length) return false;
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    
                    dfs(i, j, 0, board, word, visited);
                    if(ifexist) return true;
                }
            }
        }
        
        
        
        return false;
    }
    
    void dfs(int i, int j, int ch, char[][] board, String word, boolean[][] visited){
        if(ch == word.length()){
            ifexist = true; 
            return;
        }
        if(i < 0  || j < 0 || i >= board.length || j >= board[0].length || ifexist || visited[i][j]) return;
        visited[i][j] = true;
        if(word.charAt(ch) == board[i][j]){
            dfs(i - 1, j, ch + 1, board, word, visited);
            dfs(i + 1, j, ch + 1, board, word, visited);
            dfs(i, j - 1, ch + 1, board, word, visited);
            dfs(i, j + 1, ch + 1, board, word, visited);
        }
        visited[i][j] = false;
    }
}