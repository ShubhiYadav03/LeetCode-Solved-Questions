class Solution {
    public int rob(int[] ratings) {
       if(ratings.length == 1) return ratings[0];
        if(ratings.length == 2) return Math.max(ratings[0], ratings[1]);
        int prev = ratings[ratings.length - 2], last = ratings[ratings.length - 1];
        ratings[ratings.length - 3] = ratings[ratings.length - 3] + ratings[ratings.length - 1];
        for(int i = ratings.length - 4; i >=0; i--){
            ratings[i] = ratings[i] + Math.max(prev, last);
            last = prev;
            prev = ratings[i + 1];
        }
        
        return Math.max(ratings[0], ratings[1]);
        
    }
}