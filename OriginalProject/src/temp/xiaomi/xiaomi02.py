import sys

T = int(input().strip())
for _ in range(T):
    n = int(input().strip())
    arr1 = list(map(int, input().strip().split()))
    arr2 = list(map(int, input().strip().split()))
    flag1 = True

    # 找降序数组
    pre = sys.maxsize
    for idx in range(n):
        num1 = arr1[idx]
        num2 = arr2[idx]
        max_num = max(num1, num2)
        if max_num <= pre:
            pre = max_num
        else:
            # 连续两次异或，变为另一个数
            # 等价于 if max_num == num1: max_num = num2 else: max_num = num1
            max_num ^= num1
            max_num ^= num2
            if max_num <= pre:
                pre = max_num
            else:
                flag1 = False
                break

    # 找升序数组
    pre = 0
    flag2 = True
    for idx in range(n):
        num1 = arr1[idx]
        num2 = arr2[idx]
        min_num = min(num1, num2)
        if min_num >= pre:
            pre = min_num
        else:
            # 连续两次异或，变为另一个数
            # 等价于 if min_num == num1: min_num = num2 else: min_num = num1
            min_num ^= num1
            min_num ^= num2
            if min_num >= pre:
                pre = min_num
            else:
                flag2 = False
                break
    print("YES") if flag1 or flag2 else print("NO")
