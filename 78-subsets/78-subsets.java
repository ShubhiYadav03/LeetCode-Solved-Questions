class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList();
        generateSubsets(0, nums, new ArrayList(), list);
        
        return list;
    }
    
    void generateSubsets(int index, int[] nums, List<Integer> curr, List<List<Integer>> list){
        list.add(new ArrayList(curr));
        for(int i = index; i < nums.length; i++){
            curr.add(nums[i]);
            generateSubsets(i+1, nums, curr, list);
            curr.remove(curr.size()-1);
        }
    }
}