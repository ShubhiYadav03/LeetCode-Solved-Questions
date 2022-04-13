class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix=new int[n][n];
        int num=1;
        int left=0, right=matrix[0].length;
        int top=0, bottom=matrix.length;
        while(left<right&&top<bottom){
            for(int i=left;i<right;i++){
                matrix[top][i]=num;
                num++;
            }
            top++;
            for(int i=top;i<bottom;i++){
                matrix[i][right-1]=num;
               num++;
            }
             right--;
            
            if(left==right||top==bottom) break;
            
             for(int i=right-1;i>=left;i--){
               matrix[bottom-1][i]=num;
                 num++;
                
            }
            bottom--;
             for(int i=bottom-1;i>=top;i--){
                matrix[i][left]=num;
                 num++;
                
            }
            left++;
        }
        return matrix;
    }
}