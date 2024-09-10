# def fun(x):
#     print("{}".format(x % 10))
#     if x / 10 != 0:
#         fun(x / 10)


# fun(2022)


# def count_ones_in_binary(number):
#     count = 0
#     while number:
#         number &= number - 1  # 每次消除一个最低位的 1
#         count += 1
#     return count


# # 示例
# number = 29
# print(count_ones_in_binary(number))  # 输出 4


def g(n):
    c01 = 0  # 拖尾0的个数
    c11 = 0  # 拖尾0左侧连续1的个数
    temp = n
    while ((temp & 1) == 0) and (temp != 0):
        c01 += 1
        temp >>= 1
    while (temp & 1) == 1:
        c11 += 1
        temp >>= 1
    return n + (1 << (c11 - 1)) + (1 << c01) - 1


def f(n):
    return bin(n).count("1")


def get_f_n(arr: list):
    f_list = []
    for i in arr:
        f_list.append(f(i))
    return f_list


from collections import defaultdict


# def cluster_by_b(a, b):
#     # 创建一个字典，用于存储 b 中值到 a 中索引的映射
#     clusters = defaultdict(list)

#     # 遍历 b 中的值及其索引
#     for idx, value in enumerate(b):
#         clusters[value].append(a[idx])

#     # 返回所有聚类的列表
#     return list(clusters.values())


# def cluster(arr: list):
#     f_list = get_f_n(arr)
#     grouped_list = cluster_by_b(arr, f_list)
#     result = 0
#     for list in grouped_list:
#         if result < len(grouped_list):
#             result = max_len(list)
#     return result


def answer(arr: list):
    # 先按照fx排序，再按照x的自然顺序排序
    # 相当于原方法的聚类
    arr.sort(key=lambda x: (f(x), x))

    ans = 1
    cnt = 1
    for i in range(1, len(arr)):
        if arr[i] == g(arr[i - 1]):
            cnt += 1
        elif arr[i] == arr[i - 1]:
            continue
        else:
            ans = max(ans, cnt)
            cnt = 1
    ans = max(ans, cnt)
    return ans


def max_len(arr: list):
    result = 0
    arr.sort(key=lambda x: (f(x), x))
    # arr.sort()
    while len(arr) >= result:
        count = 1
        ele = arr.pop(0)
        while True:
            next = g(ele)
            if next in arr:
                arr.remove(next)
                ele = next
                count += 1
            else:
                break
        result = max(result, count)
    return result


arr = [1, 4, 2, 5, 3]
# print(cluster(arr))
print(max_len(arr))
arr = [1, 4, 2, 5, 3]
print(answer(arr))
