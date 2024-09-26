n, m, k = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))
arr.sort()
left = 0
right = m - 1

while right < m:
    if (arr[right] - arr[left]) <= k:
        # 不删除元素，继续
        left += 1
    right += 1
# while True:
#     if right >= len(arr):
#         break
#     if (arr[right] - arr[left]) <= k:
#         arr = arr[:left] + arr[left + 1 :]
#         # or arr.pop(left)
#     else:
#         left += 1
#         right += 1
print(len(arr))
