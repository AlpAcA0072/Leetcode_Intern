word1, word2 = map(str, input().strip().split(" "))
n, m = len(word1), len(word2)

# 如果有一个字符串为空，编辑距离就是另一个字符串的长度
if n == 0 or m == 0:
    print(n + m)

# 初始化DP数组，大小为 (n+1) x (m+1)
D = [[i + j if i * j == 0 else 0 for j in range(m + 1)] for i in range(n + 1)]

# 计算DP数组
for i in range(1, n + 1):
    for j in range(1, m + 1):
        if word1[i - 1] == word2[j - 1]:
            D[i][j] = D[i - 1][j - 1]  # 字符相同，不需要编辑
        else:
            D[i][j] = (
                min(D[i - 1][j], D[i][j - 1], D[i - 1][j - 1]) + 1
            )  # 插入、删除、替换操作

print(D[n][m])
