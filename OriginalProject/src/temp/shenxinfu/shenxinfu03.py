def min_cut_palindromic_substrings(s):
    n = len(s)
    if n == 0:
        return 0

    # 预处理回文子串
    is_palindrome = [[False] * n for _ in range(n)]
    for i in range(n):
        is_palindrome[i][i] = True
    for length in range(2, n + 1):  # 子串长度
        for start in range(n - length + 1):
            end = start + length - 1
            if s[start] == s[end]:
                if length == 2 or is_palindrome[start + 1][end - 1]:
                    is_palindrome[start][end] = True

    # 动态规划计算最少分割次数
    dp = [float("inf")] * n
    for i in range(n):
        if is_palindrome[0][i]:
            dp[i] = 0
        else:
            for j in range(i):
                if is_palindrome[j + 1][i]:
                    dp[i] = min(dp[i], dp[j] + 1)
    print(dp)
    print(is_palindrome)
    return dp[-1]


# 示例
s = "aab"
print(min_cut_palindromic_substrings(s))  # 输出：1
