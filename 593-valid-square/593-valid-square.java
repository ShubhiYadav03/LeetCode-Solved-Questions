class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        double[] distances = new double[6];
        distances[0] = Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
        distances[1] = Math.pow(p2[0] - p3[0], 2) + Math.pow(p2[1] - p3[1], 2);
        distances[2] = Math.pow(p3[0] - p4[0], 2) + Math.pow(p3[1] - p4[1], 2);
        distances[3] = Math.pow(p4[0] - p1[0], 2) + Math.pow(p4[1] - p1[1], 2);
        distances[4] = Math.pow(p4[0] - p2[0], 2) + Math.pow(p4[1] - p2[1], 2);
        distances[5] = Math.pow(p3[0] - p1[0], 2) + Math.pow(p3[1] - p1[1], 2);
        
        double diagnal = 0, side = Integer.MAX_VALUE; 
        int countDiag = 0, countSide = 0;
        for(double distance : distances){
            side = Math.min(distance, side);
            diagnal = Math.max(distance, diagnal);
        }
        if(side == 0) return false;
        
        for(double distance : distances){
            if(distance == side) countSide++;
            else if(distance == diagnal) countDiag++;
        }
        
        return countSide == 4 && countDiag == 2;  
        
    }
}