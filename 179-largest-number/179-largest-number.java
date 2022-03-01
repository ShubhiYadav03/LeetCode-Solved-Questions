class Solution {
    public String largestNumber(int[] nums) {
        String[] s=new String[nums.length];
        for(int i=0;i<nums.length;i++){
            s[i]=nums[i]+"";
        }
        Arrays.sort(s,(a,b)->{
            long  n1=Long.parseLong(a+b);
            long  n2=Long.parseLong(b+a);
           if(n1>n2) return 1;
           else if(n1<n2) return -1;
            else return 0;
        });
        String s2="";
        // StringBuilder sb=new StringBuilder("");
        // for(int i=0;i<s.length;i++){
        //     sb.append(s[i]);
        // }
        for(int i=s.length-1;i>=0;i--){
            s2+=s[i];
        }
        
        if(s2.charAt(0)=='0') return "0";
        return s2;
    }
}