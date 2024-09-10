def count(k: int, sum_limit: int, arr: list):
    count = 0

    while True:
        evaa = sum(arr[-k:])
        if evaa <= sum_limit:
            break
        else:
            top = arr.pop()
            min_value = min(top - arr[-1], evaa - sum_limit)
            min_value = max(min_value, 1)
            top -= min_value
            count += min_value
            for i in range(len(arr) - 1, -1, -1):
                if arr[i] < top:
                    arr.insert(i + 1, top)
                    break
    return count


t = int(input())

for _ in range(t):
    n, k, sum_limit = map(int, input().split())
    arr = [i + 1 for i in range(n)]
    print(count(k=k, sum_limit=sum_limit, arr=arr))
