class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Double.compare(a[0], b[0]));
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> li=new ArrayList<>();
        li.add(intervals[0][0]);
        li.add(intervals[0][1]);
        list.add(li);
        int fi=0,si=1; //first interval and second interval
        while(si<intervals.length){
            if(list.get(fi).get(1)>=intervals[si][0]){
                if(intervals[si][1]>list.get(fi).get(1))
                   list.get(fi).set(1,intervals[si][1]);
                si++;
            }else{
                List<Integer> li2=new ArrayList<>();
                li2.add(intervals[si][0]);
                li2.add(intervals[si][1]);
                list.add(li2);
                si++;
                fi++;
            }
        }
        
        int[][] arr = list.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
        
        return arr;
    }
}