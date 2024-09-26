import heapq


def max_min_value(arr, n, k, l):
    # 创建一个最大堆
    max_heap = []

    # 初始化最小值
    min_val = min(arr)

    # 遍历所有可能的起始位置
    for i in range(n - l + 1):
        # 记录当前区间的最小值
        current_min = min(arr[i : i + l])
        # 计算改变后数组的最小值
        new_min = max(
            min_val, current_min + 1
        )  # 假设我们可以将区间值变为大于当前最小值

        # 将结果存入堆中
        heapq.heappush(max_heap, (-new_min, i))  # 使用负值来模拟最大堆

    # 选择 k 段区间
    chosen_intervals = []
    while k > 0 and max_heap:
        new_min, index = heapq.heappop(max_heap)
        chosen_intervals.append((index, index + l - 1))  # 存储区间

        k -= 1

    return chosen_intervals


# 示例
arr = [7, 4, 11, 2, 1, 4, 7, 5]
n = len(arr)
k = 2
l = 3
intervals = max_min_value(arr, n, k, l)
print(intervals)
