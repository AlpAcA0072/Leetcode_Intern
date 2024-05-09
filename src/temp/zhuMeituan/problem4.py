def find_factors_count(n):
    count = 0
    i = 1
    while i * i <= n:
        if n % i == 0:
            count += 1
            if i != n // i:
                count += 1
        i += 1
    return count

def dfs(node, visited, adj, nodes_product):
    stack = [node]
    product = 1
    while stack:
        node = stack.pop()
        visited[node] = True
        product *= (node + 1)  # Node ID is index+1
        for neighbor in adj[node]:
            if not visited[neighbor] and colors[neighbor] == 'R':
                stack.append(neighbor)
    return product

def solve(n, edges, colors):
    MOD = 1e9 + 7
    adj = [[] for _ in range(n)]
    for u, v in edges:
        adj[u-1].append(v-1)
        adj[v-1].append(u-1)

    visited = [False] * n
    total_factors = 0

    for i in range(n):
        if colors[i] == 'R' and not visited[i]:
            product = dfs(i, visited, adj, i+1)
            factors_count = find_factors_count(product)
            total_factors = (total_factors + factors_count) % MOD

    return total_factors

# Example input
colors = "WRR"
edges = [(1, 2), (2, 3)]
n = len(colors)

print(solve(n, edges, colors))  # Expected output: 4
