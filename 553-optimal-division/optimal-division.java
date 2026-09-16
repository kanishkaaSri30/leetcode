class Solution {
    private Pair<String, Double> solve(int[] nums, int idx) {
        if (idx == nums.length - 1)
            return new Pair<String, Double>(nums[idx] + "", (double) nums[idx]);
        else if (idx == nums.length - 2)
            return new Pair<String, Double>(+nums[idx] + "/" + nums[idx + 1], (double) nums[idx] / nums[idx + 1]);

        double adiv = (double) nums[idx] / nums[idx + 1];
        Pair<String, Double> apair = solve(nums, idx + 2);
        adiv /= apair.getValue();
        double bdiv = nums[idx];
        Pair<String, Double> bpair = solve(nums, idx + 1);
        bdiv /= bpair.getValue();
        if (adiv < bdiv) {
            return new Pair<String, Double>(+nums[idx] + "/" + nums[idx + 1] + "/" + apair.getKey(), adiv);
        }
        return new Pair<String, Double>(nums[idx] + "/" + bpair.getKey(), bdiv);

    }

    public String optimalDivision(int[] nums) {
        if(nums.length == 1) return nums[0]+"";
        else if(nums.length == 2) return nums[0]+"/"+nums[1];
        Pair<String, Double> pair = solve(nums, 1);
        return nums[0]+"/("+pair.getKey()+")";
    }
}