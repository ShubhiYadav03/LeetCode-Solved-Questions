class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums2.length > nums1.length) intersect(nums2, nums1);
        
        HashMap<Integer, Integer> hm = new HashMap();
        
        for(int num : nums1){
            if(hm.containsKey(num)) hm.put(num, hm.get(num) + 1);
            else hm.put(num, 1);
        }
        
        ArrayList<Integer> list = new ArrayList();
        for(int num : nums2){
            if(hm.containsKey(num)){
                list.add(num);
                hm.put(num, hm.get(num) - 1);
                if(hm.get(num) == 0) hm.remove(num);
            }
            
            
        }
        
      
        return list.stream().mapToInt(i->i).toArray();
    }
}