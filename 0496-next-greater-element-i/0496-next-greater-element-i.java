class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        st.push(0);
        int i = 1;
        while(!st.isEmpty() && i < nums2.length){
            while(!st.isEmpty() && nums2[st.peek()] < nums2[i]){
                int num = nums2[st.pop()];
                if(map.containsKey(num)) nums1[map.get(num)] = nums2[i];
            }
            st.push(i);
            i++;
        }
        
        while(!st.isEmpty()){
            int num = nums2[st.pop()];
            if(map.containsKey(num)) nums1[map.get(num)] = -1;
        }
        
        return nums1;
    }
}