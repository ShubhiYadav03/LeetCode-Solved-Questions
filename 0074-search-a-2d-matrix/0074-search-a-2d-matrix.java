class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int srow = 0, scol = 0;
        int erow = matrix.length - 1, ecol = matrix[0].length - 1;
        int mrow = 0;
        while(srow <= erow){
            mrow = srow + (erow - srow)/2;
            
            if(target == matrix[mrow][0]){
                return true;
            }
            if(target < matrix[mrow][0]) erow = mrow - 1;
            else srow = mrow + 1; 
        }
        erow = (erow >= 0) ? erow : srow;
        System.out.println(erow);
        while(scol <= ecol){
            int mcol = scol + (ecol - scol)/2;
            
            if(target == matrix[erow][mcol]){
                return true;
            }
            if(target < matrix[erow][mcol]) ecol = mcol - 1;
            else scol = mcol + 1; 
        }
        
        return false;
    }
}