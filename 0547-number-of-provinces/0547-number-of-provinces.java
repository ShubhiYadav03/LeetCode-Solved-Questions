class DisjointSet{
    List<Integer> parent = new ArrayList();
    List<Integer> size = new ArrayList();  
    
    DisjointSet(int n){
        for(int i = 0; i < n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUlPar(int node){
        if(parent.get(node) == node)
            return node;
        int ulp = findUlPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    
    void unionBySize(int u, int v){
        int ulpu = findUlPar(u);
        int ulpv = findUlPar(v);
        
        if(ulpu < ulpv){
            parent.set(ulpu, ulpv);
            size.set(ulpv, size.get(ulpu) + size.get(ulpv));
        }
        else{
            parent.set(ulpv, ulpu);
            size.set(ulpu, size.get(ulpu) + size.get(ulpv));
        }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if(n == 1) return 1;
        
        DisjointSet ds = new DisjointSet(n);
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < isConnected[0].length; j++){
                if(isConnected[i][j] == 1){
                    ds.unionBySize(i, j);
                }
            }
        }
        
        int provinces = 0;
        
        for(int i = 0; i < ds.parent.size(); i++){
            if(i == ds.parent.get(i)){
                provinces++;
            }
        }
        
        return provinces;
    }
}