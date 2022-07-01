class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparingInt(o -> -o[1]));
        int ans = 0, i = 0;
        
        while(i < boxTypes.length && truckSize > 0){
            int min = Math.min(boxTypes[i][0], truckSize);
            ans += min * boxTypes[i][1];
            truckSize -= min;
            i++;
        }
        
        return ans;
    }
}

// if(truckSize - boxTypes[i][0] >= 0){
//                 truckSize -= boxTypes[i][0];
//                 ans += boxTypes[i][0] * boxTypes[i][1];
//             }
//             else{