T = int(input().strip())
for _ in range(T):
    n, m = map(int, input().strip().split())
    the_map = [[] for _ in range(n + 1)]
    for _ in range(m):
        u, v = map(int, input().strip().split())
        the_map[u].append(v)
        the_map[v].append(u)
