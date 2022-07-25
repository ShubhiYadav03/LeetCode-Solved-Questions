class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int left=0,repeat=0,max=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            if(!map.containsKey(ch)){
                map.put(ch,0);
            }
            map.put(ch,map.get(ch)+1);
            repeat = Math.max(repeat,map.get(ch));
            if(right-left+1-repeat>k){
                char delete = s.charAt(left);
                map.put(delete,map.get(delete)-1);
                left++;
                
            }
            max=Math.max(max,right-left+1);
            
        }
        return max;
    }
}