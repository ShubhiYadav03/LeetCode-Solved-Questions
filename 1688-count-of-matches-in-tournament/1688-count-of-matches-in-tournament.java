class Solution {
    public int numberOfMatches(int n) {
        int count=0;
        while(n!=1){
            if(n%2==0){
                n=n/2;
                count+=n;
            }
            else{
                n=n/2+1;
                count+=n-1;
            }
            
        }
        return count;
    }
}