class Solution {
    public int minDeletions(String s) {

    HashMap<Character,Integer> hm = new HashMap<>();
    char ch[] = s.toCharArray();
    for(int i = 0; i<ch.length ; i++)
    {
        hm.put(ch[i],hm.getOrDefault(ch[i],0)+1);
    }
    
    ArrayList<Character> list=new ArrayList<>();
        for(char c: hm.keySet()) {
            System.out.println(c + " " +hm.get(c));
            list.add(c);
        }
        
        Collections.sort(list,(a,b)->hm.get(a).compareTo(hm.get(b)));
        Collections.reverse(list);
        
        int expected = hm.get(list.get(0));
        int del = 0;
        
        for(char c: list) {
    
            if( hm.get(c) > expected){
                del +=  hm.get(c) - expected;
            }
            else if(hm.get(c) < expected){
                expected = hm.get(c);
            }
            
            if(expected > 0) expected-- ;
                
        }
        return del;
    }
}