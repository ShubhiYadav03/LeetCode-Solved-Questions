class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums.length];
        st.push(0);
        for(int i=1;i<nums.length;i++){
            while(st.size()>0&&nums[st.peek()]<nums[i]){
                ans[st.peek()]=nums[i];
                st.pop();
                
            }
            st.push(i);
            
        }
        if(!st.isEmpty()){
            for(int i=0;i<=st.peek();i++){
            while(st.size()>0&&nums[st.peek()]<nums[i]){
                ans[st.peek()]=nums[i];
                st.pop();              
            }
        }
            while(st.size()>0){
                ans[st.peek()]=-1;
                st.pop();              
            }
            
    }
        
        return ans;
}
}