n, m = map(int, input().strip().split())
min_value = 1
max_value = n
for _ in range(m):
    l, r = map(int, input().strip().split())
    min_value = max(min_value, l)
    max_value = min(max_value, r)

print(max(max_value-min_value+1, 0))