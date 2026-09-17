class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
       int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int left = 0;
        int sum = 0;
        int minlen = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target && left <= right) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                int currlen = right - left + 1;
                if (left > 0 && dp[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, currlen + dp[left - 1]);
                }
                
                minlen = Math.min(minlen, currlen);
            }
            
            
            dp[right] = minlen;
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}