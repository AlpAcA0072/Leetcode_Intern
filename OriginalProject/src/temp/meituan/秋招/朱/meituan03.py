def can_plant_trees(a, L, k):
    total = 0
    for idx, pos in enumerate(a):
        if idx == len(a) - 1 or a[idx + 1] - pos > L:
            total += L
        else:
            total += a[idx + 1] - pos
        if total >= k:
            return True
    return False


# def max_trees(list_of_points, n, k):
#     count = 0  # 用于统计可以种的树的数量
#     i = 0  # 初始化指针

#     while i < len(list_of_points):
#         # 当前点可以种树
#         count += 1
#         # 当前点种树后，树的右端点位置
#         current_position = list_of_points[i] + n

#         # 移动指针找到下一个适合种树的点
#         while i < len(list_of_points) and list_of_points[i] <= current_position:
#             i += 1
#         if count >= k:
#             return True
#     return False


def min_length_to_plant_trees(a, k):
    l, r = 1, k
    while l < r:
        mid = (l + r) // 2
        if can_plant_trees(a, mid, k):
            r = mid  # 如果可以种至少 k 棵树，则尝试更小的区间长度
        else:
            l = mid + 1  # 如果不能种至少 k 棵树，则需要更大的区间长度
    return l


# 示例输入
a = [1, 2, 5]
n = len(a)
k = 1000000
# 计算最小区间长度
min_L = min_length_to_plant_trees(a, k)
print(f"最小的区间长度为: {min_L}")
