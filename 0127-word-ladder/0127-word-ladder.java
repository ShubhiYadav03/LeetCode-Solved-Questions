class Pair{
    String word;
    int steps;
    
    Pair(String str, int s){
        word = str;
        steps = s;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        
        for(String word : wordList){
            set.add(word);
        }
  
        Queue<Pair> q = new ArrayDeque();
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()){
            Pair pair = q.remove();
            String word = pair.word;
            int steps = pair.steps;
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    String pattern = word.substring(0, i) + ch + word.substring(i + 1, word.length());
                    if(set.contains(pattern) && pattern.equals(endWord)) return steps + 1;
                    if(set.contains(pattern)){
                        set.remove(pattern);
                        q.add(new Pair(pattern, steps + 1));
                    }
                }
            }
        }
        
        return 0;
    }
}