class Solution {
    public int countPrimes(int n) {
        boolean[] arr = new boolean[n + 1];
    Arrays.fill(arr,true);
    for (int p = 2; p * p <= n; p++) {
        if (arr[p] == true) {
            for (int i = p * p; i <= n; i += p) {
                arr[i] = false;
            }
        }
    }
    int count = 0;
    for (int i = 2; i < n; i++) {
        if (arr[i] == true) {
            count++;
        }
    }
    return count;
}
}