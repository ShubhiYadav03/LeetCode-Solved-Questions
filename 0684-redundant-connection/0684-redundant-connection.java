class DisjointSet{
    List<Integer> parent = new ArrayList();
    List<Integer> size = new ArrayList();  

    DisjointSet(int n){
        for(int i = 0; i < n + 1; i++){
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
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);
        int[] ans = new int[2];
        for(int[] edge : edges){
            if(ds.findUlPar(edge[0]) == ds.findUlPar(edge[1])) {
                ans[0] = edge[0];
                ans[1] = edge[1];   
            }
            else
                ds.unionBySize(edge[0], edge[1]);
        }
        return ans;
    }
}