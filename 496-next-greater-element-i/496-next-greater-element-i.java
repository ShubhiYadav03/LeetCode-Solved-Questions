class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums2.length];
        int[] res=new int[nums1.length];
        st.push(nums2[nums2.length-1]);
        ans[nums2.length-1]=-1;
        for(int j=nums2.length-2;j>=0;j--){
            while(!st.isEmpty()&&st.peek()<=nums2[j]) st.pop();
            if(st.isEmpty()) ans[j]=-1;
            else ans[j]=st.peek();
            
            st.push(nums2[j]);
        }
        
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                if(nums1[i]==nums2[j])
                    res[i]=ans[j];
            }
        }
        return res;
    }
}