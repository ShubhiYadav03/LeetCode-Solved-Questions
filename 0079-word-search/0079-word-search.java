class Solution {
    // boolean ifexist = false;
    public boolean exist(char[][] board, String word) {
       if(word.length() > board.length * board[0].length) return false;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if(dfs(i, j, 0, board, word, visited)) return true;
                }
            }
        }
        
        
        
        return false;
    }
    
    boolean dfs(int i, int j, int ch, char[][] board, String word, boolean[][] visited){
        if(ch == word.length()){
            return true;
        }
        if(i < 0  || j < 0 || i >= visited.length || j >= visited[0].length || visited[i][j] || (word.charAt(ch) != board[i][j]))
            return false;
        boolean res = false;
        visited[i][j] = true;
        res = res | dfs(i - 1, j, ch + 1, board, word, visited);
        res = res | dfs(i + 1, j, ch + 1, board, word, visited);
        res = res | dfs(i, j - 1, ch + 1, board, word, visited);
        res = res | dfs(i, j + 1, ch + 1, board, word, visited);
        visited[i][j] = false;
        return res;
    }
}