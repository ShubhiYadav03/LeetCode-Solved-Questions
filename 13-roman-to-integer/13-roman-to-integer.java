class Solution {
    public int romanToInt(String s) {
        int num=0,ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='I') num=1;
             else if(s.charAt(i)=='V') num=5;
             else if(s.charAt(i)=='X') num=10;
             else if(s.charAt(i)=='L') num=50;
             else if(s.charAt(i)=='C') num=100;
             else if(s.charAt(i)=='D') num=500;
             else if(s.charAt(i)=='M') num=1000;
             
            if(i<s.length()-1&&s.charAt(i)=='I'&& (s.charAt(i+1)=='V'||s.charAt(i+1)=='X')) num=-1;
        else if(i<s.length()-1&&s.charAt(i)=='X'&& (s.charAt(i+1)=='L'||s.charAt(i+1)=='C')) num=-10; 
        else if(i<s.length()-1&&s.charAt(i)=='C'&& (s.charAt(i+1)=='D'||s.charAt(i+1)=='M')) num=-100;  
            
         ans=ans+num;   
        }
        return ans;
    }
}