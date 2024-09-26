def can_sum_in_range(nums, a, b):
    total_sum = sum(nums)

    # 创建一个 dp 数组，大小为 total_sum + 1
    dp = [False] * (total_sum + 1)
    dp[0] = True  # 和为 0 是可能的

    # 更新 dp 数组
    for num in nums:
        for j in range(total_sum, num - 1, -1):
            dp[j] = dp[j] or dp[j - num]

    # 检查区间 [a, b]
    for i in range(a, min(b, total_sum) + 1):
        if dp[i]:
            return True

    return False


# 示例
nums = [6]
a = 7
b = 10
print(can_sum_in_range(nums, a, b))  # 输出: True 或 False
