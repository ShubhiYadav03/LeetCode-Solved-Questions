class Solution {
    public int reverse(int x) {
        double rev =  0;
        int n=x;
        while(n!=0){
            rev=n%10+rev*10;
            
            n=n/10;
        }
        if(rev>=Integer.MAX_VALUE || rev<=Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}