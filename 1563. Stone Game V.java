class Solution {
 
        int [] prefix;
        int [][] dp;

        public int stoneGameV(int[] stoneValue) {
            int n = stoneValue.length;
            prefix = new int[n + 1];
            dp = new int[n][n];

            for (int i = 0 ;i < n ; i++){
                prefix[i + 1] = prefix[i] + stoneValue[i];
            }
            return helper(stoneValue, 0 ,n - 1);
        }
        private int helper(int [] stoneValue, int l ,int r){
            if(l == r) return 0 ;
            if(dp[l][r] != 0) return dp[l][r];

            int best = 0 ;
            for(int k = l; k < r ; k++){
                int leftSum = prefix[k + 1] - prefix[l];
                int rightSum = prefix[r + 1] - prefix[k + 1];
                if(leftSum < rightSum){
                    best = Math.max(best, leftSum + helper(stoneValue, l, k));
                }else if (leftSum > rightSum) {
                    best = Math.max(best, rightSum + helper(stoneValue, k + 1, r));
                }else {
                    best = Math.max(best, leftSum + helper(stoneValue, l, k));
                    best = Math.max(best, rightSum + helper(stoneValue, k + 1, r));
                }
            }
            return dp[l][r] = best;
        }
    }


