class Solution {
    public int arrangeCoins(int n) {
        int x = n;
        int i = 1;
        do {
            x = x - i;
            i++;
        } while (x >= 0);
        return i - 2;
    }
}