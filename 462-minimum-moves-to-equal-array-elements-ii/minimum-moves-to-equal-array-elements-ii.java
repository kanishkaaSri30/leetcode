class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        long totalMoves = 0;

        // Pair values from the two ends and move toward the median.
        while (left < right) {
            totalMoves += (long) nums[right] - nums[left];
            left++;
            right--;
        }

        return (int) totalMoves;
    }
}