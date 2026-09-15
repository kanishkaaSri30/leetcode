class Solution {
    public int mergeStones(int[] stones, int K) {
        final int LEN = stones.length;
        int[][] dp = new int[LEN + 1][LEN + 1];
        int[] prefixSum = new int[LEN + 1];
        
        // Intuition: Every time we merge K stones, we are left with 1 stone
        // In other words, LEN reduces by (K - 1) stones
        // We also know that finally we will be left with 1 stone
        // If we generalize the principle for 'x' merges:
        // LEN - x*(K - 1) = 1 => (LEN - 1) = x*(K - 1) => (LEN - 1) % (K - 1) = 0
        // This principle is also used below to check if the current length
        // under consideration is a valid combination given K
        if ((LEN - 1) % (K - 1) != 0) {
            return -1;
        }
        
        // Prefix sum helps us to quickly determine sum of elements
        // i..j (0 <= i < j < LEN)
        for (int index = 0; index < LEN; index++) {
            prefixSum[index + 1] = prefixSum[index] + stones[index];
        }
        
        // k represents current size of subproblem under consideration
        // Key intuition: The trick here is, k NEED NOT be a multiple of K, but 'm' (see code below) needs
        // to be a multiple of K
        // However, we still need to ensure k >= K so that "m" can satisfy the constraint of the problem
        for (int k = K; k <= LEN; k++) { 
            // i represents the start index of the pile under consideration
            for (int i = 0; i <= LEN - k; i++) { 
                // size of the pile determines end index of the pile given the start index
                int j = i + k -1; 
                // Assign max cost before optimizing
                dp[i][j] = Integer.MAX_VALUE;
                // Key intuition: m always needs to increase in quantum of K.
                // Also to note, if we need a pile of size K, then
                // m needs to increase by K - 1, since beginning and end index together will
                // contribute "1" in the sum!
                for (int m = i; m < j; m += K - 1) {
                    // Critical intuition: Cost of merging given pile is really
                    // Cost of arriving at two sub-pies making up the given pile PLUS
                    // the sum of all elements of the given pile
                    // HOWEVER, the latter sum should only be done when the given pile
                    // follows the constraints of a 'move' - please see below
                    dp[i][j] = Math.min(dp[i][j], dp[i][m] + dp[m + 1][j]);
                }
                // At this point, we have optimized dp[i][j] for all values of m
                // Key intuition: at this point, we need to check if the size
                // of the pile adheres to key principle of a "move" (= K).
                // If we do not do this, then the sum will not be optimal!
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefixSum[j + 1] - prefixSum[i];
                }
            }
        }
        return dp[0][LEN - 1];
    }
}