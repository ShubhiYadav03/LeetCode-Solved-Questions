class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long hb = 0, vb = 0, prev = 0;
        hb = Math.max(hb, h - horizontalCuts[horizontalCuts.length - 1]);
        vb = Math.max(vb, w - verticalCuts[verticalCuts.length - 1]);
        for(int i = 0; i < horizontalCuts.length; i++){
            hb = Math.max(hb, horizontalCuts[i] - prev);
            prev = horizontalCuts[i];
        }
        
        prev = 0;
        for(int i = 0; i < verticalCuts.length; i++){        
            vb = Math.max(vb, verticalCuts[i] - prev);
            prev = verticalCuts[i];
        }
        long mod = (long)1e9+7;
        return (int)(hb * vb % mod);
    }
}