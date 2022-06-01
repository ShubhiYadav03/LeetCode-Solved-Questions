class Solution {
    public void rotate(int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
             swap(matrix,i,j);
            }   
        }
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length/2;j++){
             reverse(matrix,i,j);
            }   
        }
        
        
        System.out.println(Arrays.deepToString(matrix));
         
    }
    
    void reverse(int[][] matrix,int i,int j){
        int m=matrix.length-1;
        int temp=matrix[i][j];
        matrix[i][j]=matrix[i][m-j];
        matrix[i][m-j]=temp;
    }
    
    void swap(int[][] matrix,int i,int j){
        int temp=matrix[i][j];
        matrix[i][j]=matrix[j][i];
        matrix[j][i]=temp;
    } 
}