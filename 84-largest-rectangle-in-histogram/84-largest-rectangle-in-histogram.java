class Solution {
    public int largestRectangleArea(int[] heigths) {
        Stack<Integer> st=new Stack<>();
        st.push(0);
        int area=0;
        int[] rb=new int[heigths.length];
        
        rb[heigths.length-1]=heigths.length;
        for(int i=1;i<heigths.length;i++){
            while(st.size()>0&&heigths[i]<heigths[st.peek()]){
                rb[st.peek()]=i;
                st.pop();
            }
          
            st.push(i);
            }
        while(st.size()>0){
            rb[st.peek()]=heigths.length;
            st.pop();
        } 
        
        st=new Stack<>();
        st.push(heigths.length-1);
        int[] lb=new int[heigths.length];
        lb[0]=-1;
        for(int i=heigths.length-2;i>=0;i--){
            while(st.size()>0&&heigths[i]<heigths[st.peek()]){
                lb[st.peek()]=i;
                st.pop();
            }
            st.push(i);
            }
        while(st.size()>0){
            lb[st.peek()]=-1;
            st.pop();
        } 
        for(int i=0;i<heigths.length;i++){
            area=Math.max(area,(rb[i]-lb[i]-1)*heigths[i]);
        }
        return area;
    }
}