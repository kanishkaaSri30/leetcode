class Solution {
    public int clumsy(int n) {
        int ans = 1;
        if(n <= 4){
            if(n <= 2) return n;
            else if(n == 3) return 6;
            else if(n == 4) return 7;
        } else {
            if(n%4 == 1 || n%4 == 2) ans = n+2;
            else if(n%4 == 3) ans = n-1;
            else ans = n+1;
        }
        return ans;
    }
}