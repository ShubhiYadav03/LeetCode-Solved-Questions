class Solution {
    public int maxPoints(int[][] points) {
        if(points.length == 1) return 1;
        int max = 0;
        
        for(int i = 0; i < points.length - 1; i++){
            Map<Double, Integer> map = new HashMap();
            for(int j = i + 1; j < points.length; j++){
                Double slope = 0.0;
                if(points[j][0] != points[i][0] ){
                    slope = (double)(points[j][1] - points[i][1]) / (double)(points[j][0] - points[i][0]);
                    if(points[j][1] == points[i][1] && points[j][0] < points[i][0]) slope = Math.abs(slope);
                }else slope = Double.POSITIVE_INFINITY;
                
                if(map.containsKey(slope)){
                    map.put(slope, map.get(slope) + 1);
                }else{
                    map.put(slope, 2);
                }
                
                if(map.get(slope)>max)
                    max=map.get(slope);
            }
            // int max = 0;
            // for(double key : map.keySet()){
            //     if(map.get(key) > max) max = map.get(key);
        }
            
            // if(max > ans) ans = max;
            
         return max;
    }
}