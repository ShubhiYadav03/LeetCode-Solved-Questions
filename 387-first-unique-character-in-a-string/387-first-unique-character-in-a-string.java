

class Solution {
    public int firstUniqChar(String s) {
        //Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i))) return i;
        }
        
        return -1;
    }
}