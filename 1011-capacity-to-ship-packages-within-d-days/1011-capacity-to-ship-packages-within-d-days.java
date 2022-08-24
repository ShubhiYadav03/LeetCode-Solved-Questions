class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0, max = weights[0];
        for(int i = 0; i < weights.length; i++){
            sum += weights[i];
            max = Math.max(max, weights[i]);
        }
        int mid = 0;
        int start = max, end = sum;
        while(start <= end){
            int estdays = 1, daywt = 0;
            mid = start + (end - start)/2;
            for(int wt : weights){  
                if(daywt + wt > mid){
                    estdays++;
                    daywt = 0;
                }
                daywt += wt;
            }
            if(estdays <= days){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        return start;
    }
}