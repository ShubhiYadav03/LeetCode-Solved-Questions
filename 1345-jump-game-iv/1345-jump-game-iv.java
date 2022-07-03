class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1) return 0;
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        boolean[] visited = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(hm.containsKey(arr[i])) hm.get(arr[i]).add(i);
            else {
                ArrayList<Integer> li = new ArrayList<>();
                li.add(i);
                hm.put(arr[i], li);
            }
        }
        int ans = 0;
        boolean flag = false;
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        visited[0] = true;
        while(!q.isEmpty()){
            ans++;
            int len = q.size();
            for(int i = 0; i < len; i++){
                int temp = q.poll();
                if(temp + 1 == arr.length - 1){
                    return ans;
                }
                if(temp + 1 < arr.length && !visited[temp + 1]){
                    visited[temp + 1] = true;
                    q.add(temp + 1); 
                }
                if(temp - 1 > 0 && !visited[temp-1]){
                    visited[temp - 1] = true;
                    q.add(temp - 1); 
                }
                if(hm.containsKey(arr[temp])){
                for(int j = 0; j < hm.get(arr[temp]).size(); j++){
                    int idx = hm.get(arr[temp]).get(j);
                    if(idx == arr.length - 1) return ans;
                    if(idx != temp && !visited[idx]){
                        q.add(idx);
                        visited[idx] = true;
                    }
                }
                    hm.remove(arr[temp]);
                }
                
            }

        }
        return ans;
    }
}