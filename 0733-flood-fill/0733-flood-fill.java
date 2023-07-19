class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] != color)
            dfs(sr, sc, image, color, image[sr][sc]);
        
        return image;
    }
    
    void dfs(int i, int j, int[][] image, int color, int origColor){
        if(i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != origColor) return;
        
        image[i][j] = color;
        
        dfs(i - 1, j, image, color, origColor);
        dfs(i + 1, j, image, color, origColor);
        dfs(i, j - 1, image, color, origColor);
        dfs(i, j + 1, image, color, origColor);      
    }
}