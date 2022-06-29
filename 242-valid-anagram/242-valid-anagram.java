class Solution {
    public boolean isAnagram(String s, String t) {
        char[] chs = s.toCharArray();
        char[] cht = t.toCharArray();
        Arrays.sort(chs);
        Arrays.sort(cht);
        String ss = String.valueOf(chs);
        String st = String.valueOf(cht);
        
        return st.equals(ss);
    }
}