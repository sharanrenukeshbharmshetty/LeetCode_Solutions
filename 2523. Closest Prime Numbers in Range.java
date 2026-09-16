class Solution {
    private boolean isPrime(int num) {
        if(num <= 1) return false;
        for (int i = 2 ;i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
    public int[] closestPrimes(int left, int right) {
        int prev = -1;
        int[] ans = {-1 , -1};
        int minGap = Integer.MAX_VALUE;

        for(int i = left; i <= right ; i++){
            if (isPrime(i)) {
                if(prev != -1) {
                    int gap = i - prev;
                    if (gap < minGap) {
                        minGap = gap;
                        ans[0] = prev;
                        ans[1] = i;
                    }
                }
                prev = i;
            }
        }
        
        return ans;

    }
}