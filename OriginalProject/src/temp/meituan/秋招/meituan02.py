n = int(input())
arr = list(map(int, input().strip().split()))

count1 = 0
count2 = 0
for ele in arr:
    if ele % 2 == 0:
        count1 += ele + 1
    else:
        count2 += ele + 1
print(min(count1, count2))
