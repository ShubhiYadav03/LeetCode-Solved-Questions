class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        list.add(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= list.get(list.size() - 1)[1]){
                if(intervals[i][1] > list.get(list.size() - 1)[1])
                list.get(list.size() - 1)[1] = intervals[i][1];
            }else list.add(intervals[i]);
        }
        
        int[][] res = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            res[i][0] = list.get(i)[0];
            res[i][1] = list.get(i)[1];
        }
        return res;
    }
}