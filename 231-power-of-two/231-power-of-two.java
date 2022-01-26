class Solution {
    public boolean isPowerOfTwo(int n) {
       
//         int digit=(int)(Math.log(n)/Math.log(2))+1;
//         int r=1<<(digit-1);
//         // System.out.println(r);
        
//         if(r==n) return true;
//         return false;
      if(n<=0) return false;
        return (n & (n-1))==0;
    }
}