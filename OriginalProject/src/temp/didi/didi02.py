n = int(input())
for i in range(n):
    m = int(input())
    down = []
    up = []
    for i in range(m):
        opinion, idx = map(int, input().strip().split())
        if opinion == -1:
            up.append(idx)
        elif opinion == 1:
            down.append(idx)
    up.sort()
    down.sort()
    if (len(up) == 0 and len(down) != 0) or (len(down) == 0 and len(up) != 0):
        print("NO")
    elif len(up) == 0 and len(down) == 0:
        print("YES")
    # 提交版本代码
    # elif up[0] < down[0]:
    #     print("NO")
    # elif up[-1] > down[-1]:
    #     print("YES")
    # else:
    #     print("NO")
    # 修改版本代码
    elif up[-1] > down[-1] and up[0] > down[0]:
        print("YES")
    else:
        print("NO")
