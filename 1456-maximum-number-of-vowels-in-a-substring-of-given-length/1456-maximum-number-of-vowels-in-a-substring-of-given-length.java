class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int j = 0, max = 0, count = 0;
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i))){
                    count++;
            }
            
            if(i - j + 1 == k){
                max = Math.max(count, max);
                if(set.contains(s.charAt(j))){
                    count--;
                }
                j++;
            }
        }
        return max;
    }
}