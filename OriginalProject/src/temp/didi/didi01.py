n, m = map(int, input().strip().split())
arr = list(map(int, input().strip().split()))

# [l, r]
l = 0
r = 0
sum = arr[0]
max_len = 0
# m电量 n数量
while r < n:
    while sum > m:
        sum -= arr[l]
        l += 1
    max_len = max(max_len, r - l + 1)
    r += 1
    if r == n:
        break
    sum += arr[r]
print(max_len)
