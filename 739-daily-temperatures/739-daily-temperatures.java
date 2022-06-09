class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[temps.length];
      //  Arrays.fill(ans,0);
        int count=0;
        for(int i=0;i<temps.length;i++){
            while(!st.isEmpty()&& temps[st.peek()]<temps[i]){
                
                ans[st.peek()]=i-st.peek();    
                st.pop();
            }
            st.push(i);
        }
        return ans;
    }
}