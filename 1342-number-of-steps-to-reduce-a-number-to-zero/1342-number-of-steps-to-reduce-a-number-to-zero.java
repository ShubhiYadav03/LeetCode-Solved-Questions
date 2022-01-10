class Solution {
    public int numberOfSteps(int n) {
        int count=0;
        if(n==0) return 0;
        while(n!=0){
            int a=n&1;
            if(a==1) count=count+2;
            else count++;
            n=n>>1;
            
        }
        return count-1;
    }
}