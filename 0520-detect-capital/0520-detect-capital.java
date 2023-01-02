class Solution {
    public boolean detectCapitalUse(String word) {
    
    //    boolean isRight = true;
        boolean firstCap = false;
        boolean allCap = false;
        for(int i = 0; i < word.length(); i++){
            if(i == 0 && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                firstCap = true;
                continue;
            }
            else if(firstCap && i == 1 && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z'){
                allCap = true;
            }
            if(!firstCap && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
            if(allCap && word.charAt(i) >= 'a' && word.charAt(i) <= 'z') return false;
            if(firstCap && !allCap && word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') return false;
        }
        
        return true;
    }
}