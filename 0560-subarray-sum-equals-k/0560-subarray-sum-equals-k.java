// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         HashMap<Integer, Integer> map = new HashMap();
//         int sum = 0;
//         int count = 0;
//         map.put(0, 1);
//         for(int i = 0; i < nums.length; i++){
//             sum += nums[i];
            
//             if(map.containsKey(sum - k)){
//                 count += map.get(sum - k);
//             }
//             map.put(sum, map.getOrDefault(sum, 0) + 1);
//         }
        
//         return count;
//     }
// }


class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        if(nums.length == 1){
            if(nums[0] == k)
                return 1;
            else 
                return 0;
        }
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int count = 0;
        mp.put(0, 1);
        for(int i = 0; i<n; i++){
            sum += nums[i];
            
            if(mp.containsKey(sum - k)){
                count += mp.get(sum - k);
            } 
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        } 
    return count;
    }
}