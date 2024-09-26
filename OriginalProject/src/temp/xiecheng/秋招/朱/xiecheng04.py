from collections import defaultdict, deque


class MinCostMaxFlow:
    def __init__(self, n):
        self.n = n  # 节点数量
        self.graph = defaultdict(list)
        self.capacity = {}  # 容量
        self.cost = {}  # 边的费用

    def add_edge(self, u, v, cap, cost):
        self.graph[u].append(v)
        self.graph[v].append(u)  # 反向边
        self.capacity[(u, v)] = cap
        self.capacity[(v, u)] = 0  # 反向边容量为0
        self.cost[(u, v)] = cost
        self.cost[(v, u)] = -cost  # 反向边费用为负

    def bellman_ford(self, source, dist, parent):
        dist[source] = 0
        in_queue = [False] * self.n
        queue = deque([source])
        in_queue[source] = True

        while queue:
            u = queue.popleft()
            in_queue[u] = False
            for v in self.graph[u]:
                if self.capacity[(u, v)] > 0 and dist[u] + self.cost[(u, v)] < dist[v]:
                    dist[v] = dist[u] + self.cost[(u, v)]
                    parent[v] = u
                    if not in_queue[v]:
                        queue.append(v)
                        in_queue[v] = True

    def min_cost_max_flow(self, sources, sink):
        total_flow = 0
        total_cost = 0
        parent = [-1] * self.n

        while True:
            dist = [float("inf")] * self.n
            for source in sources:  # 从所有出发点进行 Bellman-Ford
                self.bellman_ford(source, dist, parent)

            if dist[sink] == float("inf"):
                break  # 无法到达终点

            # 找到增广路径中的最小容量
            flow = float("inf")
            v = sink
            while v != -1:
                u = parent[v]
                if u == -1:  # 无法找到增广路径
                    break
                flow = min(flow, self.capacity[(u, v)])
                v = u

            if flow == float("inf"):
                break

            # 更新流量和费用
            v = sink
            while v != -1:
                u = parent[v]
                if u == -1:  # 到达源点
                    break
                self.capacity[(u, v)] -= flow
                self.capacity[(v, u)] += flow
                total_cost += flow * self.cost[(u, v)]
                v = u

            total_flow += flow

        return total_flow, total_cost


# 示例使用
n = 7  # 总节点数量（出发点 + 中间点 + 终点）
start = [20, 100]  # 出发点列表
mid = [60, 10, 40, 80]  # 中间点列表
sink = 50  # 终点

mcmf = MinCostMaxFlow(n)
for i, s in enumerate(start):
    for j, m in enumerate(mid):
        mcmf.add_edge(i, j + len(start), 1, abs(s - m))
for j, m in enumerate(mid):
    mcmf.add_edge(j + len(start), n - 1, 1, abs(m - sink))

flow, cost = mcmf.min_cost_max_flow([i for i in range(len(start))], n - 1)
print("最大流:", flow)
print("最小费用:", cost)
