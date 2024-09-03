def count_red_subsequences(s):
    MOD = 10**9 + 7
    n = len(s)
    dp = [0] * 4
    for i in range(n):
        if s[i] == "r":
            dp[1] = (dp[1] + 1) % MOD
        if s[i] == "e":
            dp[2] = (dp[2] + dp[1]) % MOD
        if s[i] == "d":
            dp[3] = (dp[3] * 2 + dp[2]) % MOD

    return dp[3]


# 示例输入
s = "redd"
result = count_red_subsequences(s)
print(f"red 子序列的数量之和为: {result}")
