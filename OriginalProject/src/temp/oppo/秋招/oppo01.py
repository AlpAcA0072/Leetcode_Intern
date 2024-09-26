n, m, k = map(int, input().strip().split())
count = 0
while n > m:
    if n % k == 0 and n / k >= m:
        n /= k
        n = int(n)
        count += 1
    else:
        while n > m:
            count += 1
            n -= 1
print(int(count))
