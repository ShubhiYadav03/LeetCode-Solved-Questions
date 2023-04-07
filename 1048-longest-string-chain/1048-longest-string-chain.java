class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        
        int[] dp = new int[n];
        
        Arrays.fill(dp, 1);
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        int max = 1;
        
        for(int i = 1; i < words.length; i++){

            // loop through prev words
            for(int j = 0; j < i; j++){
                if(words[i].length() - words[j].length() == 1) // check only of diiference in lengths is 1
                { 
                    if(isPredecessor(words[i], words[j]))
                    {
                        dp[i] = Math.max(dp[i], 1 + dp[j]);
                    }
                }
            } 
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    boolean isPredecessor(String word, String prev){
        int n = 0, j = 0, i = 0;
        while(i < word.length() && j < prev.length()){
            if(word.charAt(i) == prev.charAt(j)){
                j++;
            }
            else{
                n++;
                if(n > 1) return false;
            }
            i++;
        }
        
        return true;
    }
}