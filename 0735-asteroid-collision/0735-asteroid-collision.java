class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();
        
        for(int i = 0 ; i < asteroids.length; i++){
            if(asteroids[i] > 0) st.push(asteroids[i]);
            else{
                while(!st.isEmpty() && st.peek() >= 0 && st.peek() < -1 * asteroids[i]){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek() == -1 * asteroids[i]) {
                    st.pop();
                    continue;
                }
                if(st.isEmpty() || st.peek() < 0) st.push(asteroids[i]);
                
            }
        }
        int[] ans = new int[st.size()];
        int i = st.size() - 1;
        while(!st.isEmpty()){
            ans[i] = st.pop();
            i--;
        }
        
        return ans;
    }
}