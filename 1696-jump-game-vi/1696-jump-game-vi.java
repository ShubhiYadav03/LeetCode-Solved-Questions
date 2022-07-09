class Pair{
    int num;
    int idx;
    Pair(int n, int i){
        num = n;
        idx = i;
    }
}

class Solution {
    public int maxResult(int[] nums, int k) {
        int sum = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(0);
        for(int i = 1; i < nums.length; i++){
            if(i - q.peek() > k) q.poll();
            
            nums[i] += nums[q.peek()]; 
            
            while(!q.isEmpty() && nums[i] >= nums[q.peekLast()]){
                q.pollLast();
            }
            q.add(i);
        }
        
        
        return nums[nums.length - 1];
    }
}