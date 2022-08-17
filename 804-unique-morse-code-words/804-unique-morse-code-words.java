class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        if(words.length == 1) return 1;
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> set = new HashSet();
        for(String word : words){
            String morse = "";
            for(int i = 0; i < word.length(); i++){
                morse += morseCode[word.charAt(i) - 'a'];
            }
            set.add(morse);
        }
        
        return set.size();
    }
}