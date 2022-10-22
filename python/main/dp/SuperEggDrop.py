from functools import lru_cache


class Solution:
    def superEggDrop(self, K: int, N: int) -> int:

        @lru_cache(None)
        def rec(k, n):
            if n <= 1:
                return n
            if k <= 1:
                return n

            lo, hi = 1, n
            # keep a gap of 2 X values to manually check later
            while lo + 1 < hi:
                mid = (lo + hi) // 2
                t1 = rec(k - 1, mid - 1)
                t2 = rec(k, n - mid)

                if t1 < t2:
                    lo = mid
                elif t1 > t2:
                    hi = mid
                else:
                    lo = hi = mid
            m = float("inf")
            for x in (lo, hi):
                dp1 = rec(k - 1, x - 1)
                dp2 = rec(k, n - x)
                m = min(m, max(dp1, dp2))
            return 1 + m

        return rec(K, N)


if __name__ == "__main__":
    solution = Solution()
    output = solution.superEggDrop(2, 10)
    print(output)
