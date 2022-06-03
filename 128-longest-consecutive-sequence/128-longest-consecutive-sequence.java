class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<2) return nums.length;
        
        HashMap<Integer,Boolean> hm=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i],true);
        }
        
        for(int key:hm.keySet()){
            if(hm.containsKey(key-1))
               hm.put(key,false);
        }
        
        
        int maxSub=0;
        for(int val: nums){
            if(hm.get(val)){
                int tl=1;
                // int st=val;
                
                while(hm.containsKey(val+tl)) tl++;
                
                if(maxSub<tl) maxSub=tl;
            }
        }
        
       return maxSub; 
    }
}