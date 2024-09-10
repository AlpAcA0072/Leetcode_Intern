def find(qs):
    deleted = set()
    results = []
    for min_value, times in qs:
        count = 0
        curr = min_value
        while count < times:
            while curr in deleted:
                curr += 1
            deleted.add(curr)
            last_deleted = curr
            count += 1
            curr += 1
        results.append(last_deleted)
    return results


n = int(input())
qs = []
for i in range(n):
    q = tuple(map(int, input().split()))
    qs.append(q)

results = find(qs)
for i in results:
    print(i)
