class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minDist = Integer.MAX_VALUE;
        int tx = target[0];
        int ty = target[1];

        for(int[] ghost : ghosts){
            int x = ghost[0];
            int y = ghost[1];


            int gDist = Math.abs(x - tx) + Math.abs(y - ty);
            minDist = Math.min(minDist, gDist);
        }

        int mDist = Math.abs(tx - 0) + Math.abs(ty - 0);
        
        if(mDist < minDist){
            return true;
        }

        return false;
    }
}