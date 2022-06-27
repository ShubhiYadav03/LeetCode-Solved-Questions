class Solution {
    public int minPartitions(String n) {
        int max=0;
        for(int i=0;i<n.length();i++){
            max=Math.max(max, n.charAt(i)-48);
        }
        return max;
    }
}