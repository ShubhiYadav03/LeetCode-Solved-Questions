class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap();
        
        for(int task : tasks){
            if(map.containsKey(task)) map.put(task, map.get(task) + 1);
            else map.put(task, 1);
        }
        
        int times = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> entry = iterator.next();
            int key = entry.getKey();
            if(map.get(key) == 1) return -1;
            
            int num = map.get(key);
            // if(num % 3 == 0 || num % 3 == 2){
                map.put(key, num/3);
                times += (num%3 == 0) ? num/3 : num/3 + 1; 
            // }
            // else{
            //     map.put(key, num/2);
            //     times
            // }
            
            if(map.get(key) == 0) iterator.remove();
        }
        
        return times;
    }
}