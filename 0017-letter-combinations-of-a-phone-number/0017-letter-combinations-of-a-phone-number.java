class Solution {
    List<String> ans = new ArrayList();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        String[] arr = {"", "","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        // System.out.println((int)dif);
        StringBuilder sb = new StringBuilder();
        dfs(0, sb, digits, arr);
        return ans;
    }
    
    void dfs(int i, StringBuilder sb, String digits, String[] arr){
        if(i >= digits.length()){
            String s = sb.toString();
            ans.add(s);
            return;
        }
        int digit = (int)digits.charAt(i) - 48;
         // System.out.println(digit);
        for(char ch : arr[digit].toCharArray()){
            sb.append(ch);
            dfs(i + 1, sb, digits, arr);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }
    
    
}