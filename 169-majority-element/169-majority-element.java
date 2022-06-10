class Solution {
    public int majorityElement(int[] nums) {
        int majority=0, count = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(count == 0)
                majority = nums[i];
           if(majority == nums[i]) 
               count++;
            else count--;  
        }
        return majority;
    
        // for(int key : hm.keySet()){
        //     if(hm.get(key)>nums.len) hm.put(nums[i],hm.get(nums[i])+1);
        //     else hm.put(nums[i],1); 
        // }
    }
}