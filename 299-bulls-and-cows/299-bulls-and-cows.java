class Solution {
    public String getHint(String guess, String secret) {
        Map<Character,Integer> mp=new HashMap<>();
        for(int i=0;i<secret.length();i++)
            mp.put(secret.charAt(i),mp.getOrDefault(secret.charAt(i),0)+1);
        int bull=0;
        int cow=0;
        for(int i=0;i<guess.length();i++){
           
            if(guess.charAt(i)==secret.charAt(i) ){
                bull++;
                if( mp.containsKey(guess.charAt(i))==false){cow--;}
                else if(mp.get(secret.charAt(i))==1)mp.remove(secret.charAt(i));
                else mp.put(secret.charAt(i),mp.get(secret.charAt(i))-1);
            }else{
                if( mp.containsKey(guess.charAt(i))==false){continue;}
                else if(mp.get(guess.charAt(i))==1)mp.remove(guess.charAt(i));
                else mp.put(guess.charAt(i),mp.get(guess.charAt(i))-1);
                cow++;
            }
        }
        return bull+"A"+cow+"B";
    }
}