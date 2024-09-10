T = int(input().strip())


def shift(arr, value, index, shifted=0.5):
    for idx, block in enumerate(arr[index:]):
        if value < block - shifted:
            return idx


for _ in range(T):
    n, L, m, b = map(int, input().strip().split())
    ai = list(map(int, input().strip().split()))
    for i in range(n):
        ai[i] = ai[i] + 0.5
    pos = 0
    jump = 0
    flag = True
    index = 0
    last_jump_index = -1
    while pos < L:
        curr_ai = ai[index:]
        for idx, block in enumerate(curr_ai):
            if pos < block - 0.5:
                pos += 1
            elif pos == block - 0.5:
                # jump
                pos += b
                jump += 1
                last_jump_index = idx
                index = shift(curr_ai, pos, index=index)
                break
            # else:
            #     raise NotImplementedError
        if jump > m:
            flag = False
            break
    if not flag:
        print("No")
    elif pos > L:
        if ai[last_jump_index - 1] > b:
            print("Yes")
        else:
            print("No")
    else:
        print("Yes")
#####################################

# import heapq


# def count(k: int, sum_limit: int, arr: list):
#     count = 0
#     heapq.heapify(arr)
#     while sum(heapq.nlargest(k, arr)) > sum_limit:
#         top = heapq.nlargest(1, arr)[0]
#         arr.remove(top)
#         top -= 1
#         heapq.heappush(arr, top)
#         count += 1
#     return count


# t = int(input())

# for _ in range(t):
#     n, k, sum_limit = map(int, input().split())
#     arr = [i + 1 for i in range(n - 1, -1, -1)]
#     print(count(k=k, sum_limit=sum_limit, arr=arr))
