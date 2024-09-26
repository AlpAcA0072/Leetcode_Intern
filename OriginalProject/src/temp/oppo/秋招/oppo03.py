n = int(input().strip())
arr = [[] for _ in range(n + 1)]
for i in range(n - 1):
    u, v = map(int, input().strip().split())
    arr[u].append(v)
    arr[v].append(u)

setA = []
setB = []
visited = []
flag = True
nexts = [1]
while nexts != []:
    temp_nexts = []
    while nexts != []:
        curr = nexts.pop()
        visited.append(curr)
        for i in arr[curr]:
            if i not in visited:
                temp_nexts.append(i)
        if flag:
            setA.append(curr)
        else:
            setB.append(curr)
    nexts = temp_nexts
    flag = not flag

count = 0
for a in setA:
    curr_edges = set(arr[a])
    minus = set(setB) - curr_edges
    count += len(minus)

print(count)
