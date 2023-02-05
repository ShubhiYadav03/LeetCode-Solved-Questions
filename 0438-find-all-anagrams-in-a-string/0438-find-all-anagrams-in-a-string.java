class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if(s.length() == 0) return list;
        int[] freq = new int[26];
        int count = 0;
        for(char ch : p.toCharArray()){
            if(freq[ch - 'a'] == 0) count++;
            freq[ch - 'a']++;
        }

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(i - j + 1 > p.length()){
                if(freq[s.charAt(j) - 'a'] == 0) count++;
                freq[s.charAt(j) - 'a']++;
                j++;
            }

            freq[s.charAt(i) - 'a']--;
            if(freq[s.charAt(i) - 'a'] == 0) count--;
            
            if(count == 0) list.add(j);
        }

        return list;
    }
}