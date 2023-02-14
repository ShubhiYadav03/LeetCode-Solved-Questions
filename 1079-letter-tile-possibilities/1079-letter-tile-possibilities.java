class Solution {
    HashSet<String> set = new HashSet();
    public int numTilePossibilities(String tiles) {
        
        char[] charr = tiles.toCharArray();
        Arrays.sort(charr);
        HashSet<String> set2 = new HashSet();
        permutation(0, charr, set2);
        // System.out.println(set2);
        for(String word : set2){
            StringBuilder sb = new StringBuilder();
            dfs(0, sb, word.toCharArray());
        }
       
        return set.size() - 1;
    }
    
    void permutation(int i, char[] nums, HashSet<String> set2){
         // if(i > nums.length) return;
        if(i == nums.length){
            String s = new String(nums);
            set2.add(s);
            return;
        }
        
        for(int j = i; j < nums.length; j++){
            if((i != j && nums[i] == nums[j])){
                // dfs(i + 1, nums);
                continue;
            } 
            else{
                swap(i, j, nums);
                permutation(i + 1, nums, set2);
                swap(i, j, nums);
            }
        }
    }
    
    void swap(int i, int j,  char[] nums){
        char temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
    void dfs(int i, StringBuilder sb, char[] charr){
        if(i == charr.length){
            // System.out.println(set);
            String s = new String(sb);
            set.add(s);
            return;
        }
        
        sb.append(charr[i]);
        dfs(i + 1, sb, charr);
        sb.deleteCharAt(sb.length() - 1);
        char ch = charr[i];
        while(i < charr.length && charr[i] == ch){
            i++;
        }
        dfs(i, sb, charr);
    }
}