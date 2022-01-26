class Solution {
    public boolean isPowerOfThree(int n) {
     return (Math.log10(n) / Math.log10(3) * 10) % 10 == 0;
    }
}