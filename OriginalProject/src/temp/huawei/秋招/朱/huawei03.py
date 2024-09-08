import math


def min_travel_distance(customers, k):
    dp = [[float("inf")] * (k + 1) for _ in range(n + 1)]
    for j in range(k + 1):
        dp[0][j] = 0  # 初始条件：公司到公司的距离为0

    def distance(i, j):
        return math.sqrt(
            (customers[i][0] - customers[j][0]) ** 2
            + (customers[i][1] - customers[j][1]) ** 2
        )

    for i in range(1, n + 1):
        for j in range(k, -1, -1):
            # 如果背包是满的，则没有必要再回公司补充
            if j == k:
                dp[i][j] = dp[i - 1][j] + distance(0, i) + distance(0, i - 1)
            # 如果背包容量充足，直接前往下一个客户
            elif j > 0:
                dp[i][j] = min(
                    dp[i - 1][j + 1] + distance(i - 1, i),
                    dp[i - 1][j + 1] + distance(0, i - 1) + distance(0, i),
                )
            # 如果背包容量不足，回公司补充后再前往下一个客户
            else:
                dp[i][j] = dp[i - 1][j + 1] + distance(0, i - 1) + distance(0, i)

    return min(dp[n][j] for j in range(k + 1)) + distance(0, n)


n, k = map(int, input().strip().split())
x, y = map(int, input().strip().split())
customers = [[x, y, 0]]
for _ in range(n):
    x, y, p = map(int, input().strip().split())
    customers.append([x, y, p])
customers = sorted(customers, key=lambda x: x[-1])
print(min_travel_distance(customers, k))
