class Solution {
    public int removePalindromeSub(String s) {
        if(s.length()==0) return 0;
        int i=0,j=s.length()-1;
        Boolean isPalindrome=true;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else if(s.charAt(i)!=s.charAt(j)){
                isPalindrome=false;
                break;
            }
        }
        
        return (isPalindrome)?1:2;
    }
}