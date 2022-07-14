class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap();
        for(int num : nums){
            if(hm.containsKey(num)) hm.put(num, hm.get(num) + 1);
            else hm.put(num, 1);
            
            if(hm.get(num) == 3) hm.remove(num);
        }
        
        for(int key : hm.keySet()){
            return key;
        }
        return -1;
    }
}