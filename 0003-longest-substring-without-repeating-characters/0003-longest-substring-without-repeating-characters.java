class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet();
        int j = 0, longestSub = 0, currMax = 0;;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                while(s.charAt(j) != ch){
                    set.remove(s.charAt(j));
                    j++;
                }
                j++;
                continue;
            }
            set.add(ch);
            currMax = i - j + 1;
            longestSub = Math.max(longestSub, currMax);
        }
        return longestSub;
    }
}