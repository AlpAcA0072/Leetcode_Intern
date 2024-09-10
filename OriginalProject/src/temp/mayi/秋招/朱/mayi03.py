def min_good_intervals(a):
    if len(a) == 1:
        return 1
    else:
        # 最右侧等比数列
        last_seq = [a[0]]
        number = 1
        for ele in a[1:]:
            last_seq = 二分查找插入有序序列(last_seq, ele)
            if not 是等比数列(lst=last_seq):
                last_seq = [ele]
                number += 1
    return number


import bisect


# 二分查找插入，为了避免多次排序
def 二分查找插入有序序列(sorted_list: list, value):
    # 使用 bisect_left 找到插入位置
    insert_index = bisect.bisect_left(sorted_list, value)
    # 在指定位置插入数值
    sorted_list.insert(insert_index, value)
    return sorted_list


def 是等比数列(lst):
    # 检查列表长度
    if len(lst) < 2:
        return True

    # 计算公比（假设列表中的元素都不为零）
    ratio = lst[1] / lst[0]

    # 检查所有相邻元素的比值是否一致
    for i in range(1, len(lst) - 1):
        if lst[i + 1] / lst[i] != ratio:
            return False

    return True


print(min_good_intervals([1, 2, 8, 4, 2, 8, 32]))
