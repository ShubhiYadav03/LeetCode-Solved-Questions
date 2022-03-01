class Solution {
    public int[] countBits(int n) {
        if(n==0) return new int[]{0};
        if(n==1) return new int[]{0,1};
        
        int[] arr=new int[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<n+1;i++){
            arr[i] = arr[i>>1] + i%2;
        }
        return arr;
    }
}