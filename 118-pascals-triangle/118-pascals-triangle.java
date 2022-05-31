class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal=new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> list=new ArrayList<>();
            list.add(1);
            for(int j=1;j<=i;j++){
                if(j==i){
                    list.add(1);
                    break;
                }
                int num=pascal.get(i-1).get(j-1)+pascal.get(i-1).get(j);
                list.add(num);
            }
            pascal.add(list);
        }
        
        return pascal;
    }
}