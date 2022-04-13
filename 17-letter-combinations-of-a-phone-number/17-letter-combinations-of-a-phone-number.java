class Solution {
    public List<String> letterCombinations(String digits) {
        
       String[] alpha={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> list=new ArrayList<String>();
        if(digits.isEmpty()) return list;
        list.addAll(permutations("",digits,alpha));
        return list;
    }
    List<String> permutations(String p, String up, String[] alpha){
        if(up.isEmpty()){
           List<String> list=new ArrayList<String>();
            list.add(p);
            return list;
        }
        
        int digit=up.charAt(0)-'0';
        List<String> list=new ArrayList<String>();
        for(int i=0;i<alpha[digit-2].length();i++){
         char ch=alpha[digit-2].charAt(i);
            list.addAll(permutations(p+ch,up.substring(1),alpha));
        }
        return list;
    }
}