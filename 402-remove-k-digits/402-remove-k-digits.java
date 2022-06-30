class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == 0) return "";
       if(num.length() == k) return "0";
        Stack<Character> st = new Stack();
        
        for(char ch : num.toCharArray()){
            while(!st.isEmpty() && ch < st.peek() && k > 0){
                st.pop();
                k--;
            }
            st.push(ch);
        }
        while(!st.isEmpty() && k > 0){
            st.pop();
            k--;
        }
        
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        ans = ans.reverse();
        while(ans.length() != 1 && ans.charAt(0) == '0'){
            ans.deleteCharAt(0);
        }
        
        
        
        return ans.toString();
    }
}