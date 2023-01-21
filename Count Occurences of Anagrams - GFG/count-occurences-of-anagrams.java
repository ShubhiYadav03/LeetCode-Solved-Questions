//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String p, String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        int[] freq = new int[26];
        int count = 0;
        for(char ch : p.toCharArray()){
            if(freq[ch - 'a'] == 0) count++;
            freq[ch - 'a']++;
        }

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(i - j + 1 > p.length()){
                if(freq[s.charAt(j) - 'a'] == 0) count++;
                freq[s.charAt(j) - 'a']++;
                j++;
            }

            freq[s.charAt(i) - 'a']--;
            if(freq[s.charAt(i) - 'a'] == 0) count--;
            
            if(count == 0) ans++;
        }

        return ans;
        // code here
    }
}