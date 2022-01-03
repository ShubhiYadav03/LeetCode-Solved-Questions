class Solution {
    public int maxArea(int[] height) {
        int ar=0,st=0,end=height.length-1;
        while(st<end){
           int min=Math.min(height[st],height[end]);
            ar=Math.max(ar,min*(end-st));

             if(min==height[st]) st++;
             else end--; 
            }
        return ar;
        }
    }
