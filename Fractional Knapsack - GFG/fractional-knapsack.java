//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class GfG {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int w = Integer.parseInt(inputLine[1]);
            Item[] arr = new Item[n];
            inputLine = br.readLine().trim().split(" ");
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Item(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            System.out.println(String.format("%.2f", new Solution().fractionalKnapsack(w, arr, n)));
        }
    }
}
// } Driver Code Ends


/*
class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
*/

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        double ans = 0;
        Arrays.sort(arr, new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            double a = (double)o1.value/o1.weight;
            double b = (double)o2.value/o2.weight;
            return Double.compare(a, b);
        }
    });
        int i = arr.length - 1;
        while(w > 0 && i >= 0){
            if(w >= arr[i].weight){
                w -= arr[i].weight;
                ans += arr[i].value;
                i--;
            }
            else if(w < arr[i].weight){
                ans += (double)arr[i].value/arr[i].weight * w;
                w = 0;
            }
        }
        
        return ans;
    }
}