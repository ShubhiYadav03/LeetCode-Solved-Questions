class Solution {
    public int largestRectangleArea(int[] heigths) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int area = 0;
        
       // rb[heigths.length-1] = heigths.length;
        for(int i = 1; i < heigths.length ; i++){
            while(st.size() > 0 && heigths[i] < heigths[st.peek()]){         
                int height = heigths[st.pop()];
                int left = (!st.isEmpty()) ? st.peek() : -1;
                area = Math.max(area, (i - left - 1) * height);
            }
            st.push(i);
        }
        
        while(st.size() > 0){
            int right = heigths.length;
            int height = heigths[st.pop()];
            int left = (!st.isEmpty()) ? st.peek() : -1;
            area = Math.max(area, (right - left - 1) * height);
        } 
        
        return area;
    }
}