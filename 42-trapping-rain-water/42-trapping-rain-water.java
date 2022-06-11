class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int maxleft = height[left], maxright = height[right];
        int area = 0;
        while(left < right){
            if(maxleft <= maxright){  
                left++;
                maxleft = Math.max(maxleft,height[left]);
                area += maxleft-height[left];                    
            }
            else{ 
                right--; 
                maxright = Math.max(maxright,height[right]);
                area += maxright-height[right];
            }
            //area += (hgt > 0) ? hgt : 0;
        }
        
        return area;
    }
}