class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks.length < 4) return false;
        int perimeter = 0, max = 0;
        for(int i = 0; i < matchsticks.length; i++){
            perimeter += matchsticks[i];
        }
        
        if(perimeter % 4 != 0) return false;
        int side = perimeter / 4;
        Arrays.sort(matchsticks);
        if(matchsticks[matchsticks.length - 1] > side) return false;
        
        return match(matchsticks, matchsticks.length - 1, 0, 0, 0, 0, side);
    }
    
    public boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
        
        if (top == target && bottom == target && left == target && right == target) return true;

        if (top > target || bottom > target || left > target || right > target) return false;
                        
        int val = matchsticks[index];
        
        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
        if (t) return true;
        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
        if (b) return true;
        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
        if (l) return true;
        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
        if (r) return true;
        
        return false;
    }
}