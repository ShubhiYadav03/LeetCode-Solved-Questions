class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < n; i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.add(i);
            
            if(i - dq.peekFirst() + 1 > k) dq.pollFirst();
            if(i >= k - 1) ans[i - k + 1] = nums[dq.peekFirst()];
        }
        
        return ans;
    }
}