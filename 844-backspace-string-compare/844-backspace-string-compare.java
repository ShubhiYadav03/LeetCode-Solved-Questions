class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            if(st.size() > 0 && s.charAt(i) == '#'){
                st.pop();
            }
            else if(s.charAt(i) != '#') st.push(s.charAt(i));
        }
        
        Stack<Character> st2 = new Stack<>();
        for(int i = 0; i < t.length(); i++){
            if(st2.size() > 0 && t.charAt(i) == '#'){
                st2.pop();
            }
            else if(t.charAt(i) != '#') st2.push(t.charAt(i));
        }
        
        while(st.size() > 0&& st2.size() > 0){
            if(st.peek() == st2.peek()){
                st.pop();
                st2.pop();
            }
            else return false;
        }
        return st.size()==0&&st2.size()==0;
    }
}