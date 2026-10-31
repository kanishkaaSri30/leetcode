class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        MOD = 10**9 + 7

        n = len(grid)
        m = len(grid[0])

        if n == 1 and m == 1:
            return 1

        # dp[i][j] = [right possibilities, down possibilities]
        dp = [[[0, 0] for _ in range(m + 1)] for _ in range(n + 1)]

        for i in range(n - 1, -1, -1):
            for j in range(m - 1, -1, -1):

                if i == n - 1 and j == m - 1:
                    dp[i][j][0] = 1
                    dp[i][j][1] = 1
                    continue

                if grid[i][j] == 1:
                    dp[i][j][0] = dp[i + 1][j][1]
                    dp[i][j][1] = dp[i][j + 1][0]

                else:
                    ways = (
                        dp[i + 1][j][1] +
                        dp[i][j + 1][0]
                    ) % MOD

                    dp[i][j][0] = ways
                    dp[i][j][1] = ways

        return (
            dp[1][0][1] + dp[0][1][0]
        ) % MOD