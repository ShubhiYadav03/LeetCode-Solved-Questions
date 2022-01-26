class Solution {
    public boolean isPowerOfFour(int n) {
       int digit=(int)(Math.log(n)/Math.log(2))+1;
       if(n<=0) return false;
       if ((n & (n-1))==0&& digit%2==1){
         return true;
     }
        return false;
    }
}