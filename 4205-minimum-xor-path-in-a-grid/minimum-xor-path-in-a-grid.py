class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        m, n = len(grid), len(grid[0])
        @cache
        def possible(xor, i, j):
            xor ^= grid[i][j]
            return (
                0 == i == j == xor or
                i and possible(xor, i - 1, j) or
                j and possible(xor, i, j - 1)
            )
        for xor in count():
            if possible(xor, m-1, n-1):
                return xor