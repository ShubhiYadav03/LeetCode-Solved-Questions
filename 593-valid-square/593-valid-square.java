class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        int[][] points = new int[][]{p1,p2,p3,p4};
        for(int i = 0; i<points.length; i++){
            for(int j = i+1; j<points.length; j++){
                set.add(distance(points[i],points[j]));
            }
        }
        return !set.contains(0) && set.size() == 2;
    }
    
    public int distance(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}