class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[nums1.length];
        HashMap<Integer,Integer> hs=new HashMap<>();
        st.push(0);
        for(int i=1;i<nums2.length;i++){
            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                hs.put(nums2[st.pop()],nums2[i]);
            }
            st.push(i);
        }
        
        while(!st.isEmpty()){
            hs.put(nums2[st.pop()],-1);
        }
        
        for(int i=0;i<nums1.length;i++){ 
            if(hs.containsKey(nums1[i])){
                res[i]=hs.get(nums1[i]);
            }           
        }
        
        return res;
    }
}