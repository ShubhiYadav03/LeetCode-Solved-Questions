class Solution {
    public int minimizedMaximum(int n, int[] q) {
       int minProd=0, maxProd=q[0];
        for(int i=0;i<q.length;i++){
            maxProd=Math.max(q[i],maxProd);
            minProd+=q[i];
        }
        if(n==q.length) return maxProd;
        minProd=(int)Math.ceil((float)minProd/n);
  
        int ans=minProd;
        while(minProd<=maxProd){
            int mid=minProd+(maxProd-minProd)/2;
            int sum=0;
            for(int i=0;i<q.length;i++) {
                sum += (int) Math.ceil((float) q[i] / mid);
            }
            if(sum<=n) {
                ans=mid;
                maxProd=mid-1;
            }
            else minProd=mid+1;

        }
        return ans;

    }

   
    
}
  