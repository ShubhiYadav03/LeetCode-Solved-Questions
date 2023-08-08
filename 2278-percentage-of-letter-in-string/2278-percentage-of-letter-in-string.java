class Solution {
    public int percentageLetter(String s, char letter) {
        int count = 0;
        
        for(char ch : s.toCharArray()){
            if(ch == letter) count++;
        }
        
        int ans = Math.round((count * 100) / s.length());
        return ans;
    }
}