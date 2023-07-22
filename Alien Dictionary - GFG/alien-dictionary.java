//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int k, int n)
    {
        List<List<Integer>> adj = new ArrayList<>(); 
        
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 1; i < dict.length; i++){
            int len = (dict[i - 1].length() < dict[i].length()) ? dict[i - 1].length() : dict[i].length(); 
            for(int j = 0; j < len; j++){
                if(dict[i - 1].charAt(j) != dict[i].charAt(j)){
                    adj.get(dict[i - 1].charAt(j) - 'a').add(dict[i].charAt(j) - 'a');
                    break;
                }
            }
        }
        
        Stack<Integer> st = new Stack();
        boolean[] visited = new boolean[n];
        boolean[] pathVisited = new boolean[n];
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                if(!dfs(i, adj, visited, pathVisited, st)){
                    return "";
                }
            }
        }
        String ans = "";
        while(!st.isEmpty()){
            ans += (char)(st.pop() + 'a');
        }
        
        return ans;
    }
    
    boolean dfs(int node,  List<List<Integer>> adj, boolean[] visited, boolean[] pathVisited, Stack<Integer> st){
        visited[node] = true;
        pathVisited[node] = true;
        
        for(int n : adj.get(node)){
            if(pathVisited[n])
                return false;
            if(!visited[n]){
                if(!dfs(n, adj, visited, pathVisited, st))
                    return false;
            }
        }
        
        pathVisited[node] = false;
        st.push(node);
        return true;
    }
}