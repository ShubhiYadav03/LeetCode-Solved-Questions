class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int ans = 0, i = 0;
        
        for(i = 0; i < boxTypes.length; i++){
            if(truckSize - boxTypes[i][0] >= 0){
                truckSize -= boxTypes[i][0];
                ans += boxTypes[i][0] * boxTypes[i][1];
            }
            else{
                ans += truckSize * boxTypes[i][1];
                break;         
            }
        }
        
        return ans;
    }
}

