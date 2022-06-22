class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList();
       // StringBuilder s=new StringBuilder();
        parentheses(n,0,0,list,"");
        
        return list;
    }
    
    void parentheses(int n,int open,int close,List<String> list,String s){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(open<n)
        parentheses(n,open+1,close,list,s+"(");
        if(close<open)
        parentheses(n,open,close+1,list,s+")");
    }
}