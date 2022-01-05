class Solution {
    public int romanToInt(String s) {
 int a[]=new int[s.length()];
        int S=0;
        

        
            int t=0;
            for(int j=a.length-1;j>=0;j--)
            {
                if(s.charAt(j)=='I')
                    a[j]=1;
                if(s.charAt(j)=='V')
                    a[j]=5;
                if(s.charAt(j)=='X')
                    a[j]=10;
                if(s.charAt(j)=='L')
                    a[j]=50;
                if(s.charAt(j)=='C')
                    a[j]=100;
                if(s.charAt(j)=='D')
                    a[j]=500;
                if(s.charAt(j)=='M')
                    a[j]=1000;
                
                if(j==a.length-1)
                {
                    S=S+a[j];
                    t=a[j];
                }
                if(a[j]<t)
                {
                    S=S-a[j];
                }
                if(j!=a.length-1&&a[j]>=t)
                {
                    S=S+a[j];
                    t=a[j];
                }
            }
        
        return S;
    }
}