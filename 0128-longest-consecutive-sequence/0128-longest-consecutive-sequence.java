class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet();
        
        for(int num : nums){
            set.add(num);
        }
        int maxStreak = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int currNum = num;
                int streak = 1;
                while(set.contains(currNum + 1)){
                    currNum++;
                    streak++;
                }
                maxStreak = Math.max(streak, maxStreak);
            }
        }
        return maxStreak;
    } 
}