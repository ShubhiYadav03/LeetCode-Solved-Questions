class Solution {
    int i=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        String str ="";
        int count =0;
    
        while(i<s.length()){
            char ch = s.charAt(i);
            i++;
            if(ch=='['){
                str=decodeString(s);
                for(int j=0;j<count;j++){
                    sb.append(str);
                }
                count=0;
            }
            else if(ch==']'){
                break;
            }
            else if(Character.isAlphabetic(ch)){
                sb.append(ch);
                
            }
            else{
                count =count*10 +ch -'0';
            }
        } 
            
       return sb.toString(); 
    }
}