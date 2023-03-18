class Solution {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i = 0; i < bills.length; i++){
            if(bills[i] == 20){
                if(map.containsKey(10) && map.containsKey(5)){
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                    if(map.get(5) == 0) map.remove(5);
                    if(map.get(10) == 0) map.remove(10);
                }
                else if(map.containsKey(5) && map.get(5) >= 3){
                    map.put(5, map.get(5) - 3);
                    if(map.get(5) == 0) map.remove(5);
                } 
                 
                else return false;
            }
            else if(bills[i] == 10){
                if(map.containsKey(5)){
                    map.put(5, map.get(5) - 1);
                    if(map.get(5) == 0) map.remove(5);
                }else return false;
                map.put(10, map.getOrDefault(10, 0) + 1);
            }
            else if(bills[i] == 5) map.put(5, map.getOrDefault(5, 0) + 1);
        }
        return true;
    }
}