def recursive(curr_node: int, left: list, visited: list):
    if curr_node != None:
        visited.append(curr_node)

        child = arr[curr_node]
        child = [i for i in child if i not in visited]

        left[len(child)] += 1
        for ele in child:
            recursive(curr_node=ele, left=left, visited=visited)
    else:
        return


T = int(input())
for _ in range(T):
    n = int(input())
    arr = []
    for i in range(n + 1):
        arr.append([])
    for _ in range(n - 1):
        i, j = input().strip().split()
        i = int(i)
        j = int(j)
        arr[i].append(j)
        arr[j].append(i)

    left = [0] * n
    curr_node = 1
    visited = []
    recursive(curr_node=curr_node, left=left, visited=visited)

    total_count = 0
    for ele in left:
        if ele != 0:
            total_count += ele * (ele - 1) / 2

    print(int(total_count))
