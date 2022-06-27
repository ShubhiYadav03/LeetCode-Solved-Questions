class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int l=0,r=0;
        int min=Integer.MAX_VALUE,sum=0,total=0;
        for(int card:cardPoints){
            total+=card;
        }
        
        while(r<cardPoints.length){
            if(r<cardPoints.length-k){
                sum+=cardPoints[r];
                r++;
                if(r==cardPoints.length-k) min=sum;
            }else{
                sum-=cardPoints[l];
                sum+=cardPoints[r];
                l++;
                r++;
                min = Math.min(min,sum);
            }
        }
        
        return total-min;
    }
}