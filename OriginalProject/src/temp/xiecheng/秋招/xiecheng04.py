def count(n: int, k: int, sum_limit: int, arr: list):
    count = 0

    for i in range(n):
        start = max(0, i - k + 1)
        curr_sum = sum(arr[start : i + 1])
        if curr_sum > sum_limit:
            excess = curr_sum - sum_limit
            arr[i] -= excess
            count += excess

        if arr[i] < 0:
            count += abs(arr[i])
            arr[i] = 0

    return count


n, k, sum_limit = map(int, input().split())
arr = list(map(int, input().split()))
print(count(n=n, k=k, sum_limit=sum_limit, arr=arr))
