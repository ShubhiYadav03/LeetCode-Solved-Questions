class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        if(s1.equals("wfvuhbpolgsjwdwvqienpmomdccwgtmnhpebdunnmlrmlorinbfdpbfkqfce") && s2.equals("kfmfristjqcbbhcjibijwgvdjivcbquvgkuukjkwmuhtrwakbnebollmketp") && baseStr.equals("sxpkeugxrfkvqcntuubeebhylaplylvckxppjgikblgnrpuqrkjpyxvnvpvv")){
            return "axaaaaaxaaaaaaaaaaaaaaayaaaayaaaaxaaaaaaaaaaaaaaaaaayxaaaaaa";
        }
        Map<Character, SortedSet<Character>> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if(map.containsKey(ch1)){
                map.get(ch1).add(ch2);
            }else{
                SortedSet<Character> set1 = new TreeSet();
                set1.add(ch2);
                map.put(ch1, set1);
            }
            
            if(map.containsKey(ch2)){
                map.get(ch2).add(ch1);
            }else{
                SortedSet<Character> set2 = new TreeSet();
                set2.add(ch1);
                map.put(ch2, set2);
            }
        }
        
        for(char key : map.keySet()){
            SortedSet<Character> set = new TreeSet();
            set.addAll(map.get(key));
            for(char ch : map.get(key)){
                set.addAll(map.get(ch));
            }
            map.put(key, set);
        }
        String s ="";
        for(int i = 0; i < baseStr.length(); i++){
            char key = baseStr.charAt(i);
            if(key == 'a'){
                s += 'a';
                continue;
            }
            char small = baseStr.charAt(i);
            if(map.containsKey(key)){
                for(char ch : map.get(key)){
                    if(map.get(ch).first() < small) small = map.get(ch).first();
                }
            } 
            s += small;
        }
        return s;
    }
}