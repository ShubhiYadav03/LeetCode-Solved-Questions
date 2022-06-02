class Solution {
    public double myPow(double x, int n) {
        
      //  double ans=1;
        int p=n<0?-1*n:n;
        
        
        double ans=pow(x,p);
        return (n>0)?ans:1/ans;
        
        
    }
    public double pow(double x, int n) {
        if (n ==0) return 1;
        if(x==0) return 0;
        //if(n==1) return x;
        double res=pow(x,n/2);
        res=res*res;
        return (n%2==0)? res:res*x;
        
        
    }
}