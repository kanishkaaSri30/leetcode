class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] remainders = new int[60];
        for (int t : time) {
            remainders[t % 60]++;
        }

        long count = 0;

        // Case 1: Songs with remainder 0
        count += (long)remainders[0] * (remainders[0] - 1) / 2;

        // Case 2: Songs with remainder 30
        count += (long)remainders[30] * (remainders[30] - 1) / 2;

        // Case 3: Complementary pairs (i and 60 - i)
        for (int i = 1; i < 30; i++) {
            count += (long)remainders[i] * remainders[60 - i];
        }

        return (int)count;
    }
}