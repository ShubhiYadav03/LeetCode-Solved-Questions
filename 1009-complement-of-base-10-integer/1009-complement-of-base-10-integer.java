class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        int temp=n, ans=0,p=1;
        while(temp!=0){
            int rem=(temp%2==1)?0:1;
            temp=temp/2;
            ans=ans+rem*p;
            p=p*2;
        }
        return ans;
    }
}