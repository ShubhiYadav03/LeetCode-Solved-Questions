class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> list = new ArrayList();
        list.add(intervals[0]);
        int j = 0;
        for(int i = 1; i < intervals.length; i++){
            if(list.get(j)[1] >= intervals[i][0]){
                if(list.get(j)[1] >= intervals[i][1]) continue;
                else{
                    list.get(j)[1] = intervals[i][1];
                }
            }
            else{
                list.add(intervals[i]);
                j++;
            }
        }
        
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}