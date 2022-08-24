class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         int max = piles[0];
         for(int i = 1; i < piles.length; i++){
                max=Math.max(max, piles[i]);
            }
        if(piles.length == h){          
            return max;
        }
        int min = 0;
        int k = max;  
        while(min <= max){
            int sum = 0;
            int mid = min + (max - min) / 2;
            for(int i = 0; i < piles.length; i++){
                sum = sum + (int)Math.ceil((piles[i] * 1.0) / mid);
            }
            if(sum > h) min = mid + 1;
            else if(sum <= h) {
                max = mid - 1;
                k = mid;
            }
        }
        return k;
        
        }
        
}
