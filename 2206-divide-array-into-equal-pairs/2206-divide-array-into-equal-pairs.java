class Solution {
    public boolean divideArray(int[] nums) {
        int pairs=nums.length/2;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.put(nums[i],map.get(nums[i])+1);
            else map.put(nums[i],1);
        }
        int sum=0;
        for(int key:map.keySet()){
            int n = map.get(key);
            sum+= (n%2 == 0) ? n/2 : n/2 + 1;
        }
    
        return sum==pairs;
    }
}