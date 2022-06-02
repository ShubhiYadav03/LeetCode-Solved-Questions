class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int end=matrix[0].length-1;
        
        for(int i=0;i<matrix.length;){
            if(target == matrix[i][end]) return true;
            if(target < matrix[i][end]) return search(matrix, i,target);
            if(target > matrix[i][end]) i++;
        }
        return false;
    }
    boolean search(int[][] matrix, int row, int target){
        int start=0, end=matrix[0].length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            
            if(matrix[row][mid]==target) return true;
            if(matrix[row][mid]>target) end=mid-1;
            else start=mid+1;
            
        }
        return false;
    }
}