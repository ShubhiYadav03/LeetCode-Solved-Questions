class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        ArrayList<StringBuilder> list=new ArrayList<>(numRows);
        int k=0;
        for(int i=0;i<numRows;i++){
            list.add(new StringBuilder(""));
        }
        for(int i=0;i<s.length();i+=numRows*2-2){
            for(int j=0;j<numRows&&k<s.length();j++){
                list.get(j).append(s.charAt(k));
                k++;
            }
            for(int j=numRows-2;j>0&&k<s.length();j--){
                list.get(j).append(s.charAt(k));
                k++;
            }
        }
        String ans=""; 
        for(StringBuilder sb: list){
            ans+=sb;
        }
        
        return ans;
    }
}