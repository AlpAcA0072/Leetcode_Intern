def dfs(node, tree, visited, path_xor_sum, result):
    """
    使用深度优先搜索计算从根节点到每个节点的路径上的异或和。

    :param node: 当前访问的节点
    :param graph: 图的邻接表表示
    :param visited: 访问标记数组
    :param path_xor_sum: 当前路径上的累积异或和
    :param result: 结果字典，记录每个节点对应的异或和
    """
    # 标记当前节点为已访问
    visited[node] = True
    # 更新结果
    result[node] = path_xor_sum

    # 对于当前节点的所有邻居
    for neighbor, weight in tree[node]:
        if not visited[neighbor]:
            # 更新路径上的累积异或和
            new_path_xor_sum = path_xor_sum ^ weight
            # 递归访问邻居节点
            dfs(neighbor, tree, visited, new_path_xor_sum, result)
            # 回溯，恢复父节点的状态
            path_xor_sum = new_path_xor_sum ^ weight


def find_number_of_k(k: int, result: dict):
    count = 0
    for i in result.values():
        count += 1 if i == k else 0
    print(count)


# 示例用法
if __name__ == "__main__":
    # 假设节点编号从0开始

    n, q = map(int, input().strip().split())  # 节点数
    # 创建一个邻接表表示图
    tree = [[] for _ in range(n + 1)]
    for i in range(n - 1):
        u, v, w = map(int, input().strip().split())
        tree[u].append((v, w))
        tree[v].append((u, w))

    # 初始化访问标记和结果字典
    visited = [False] * (n + 1)
    result = {}

    # 开始DFS遍历
    dfs(1, tree, visited, 0, result)

    print("Path XOR sums from root:", result)
    for i in range(q):
        node, k = map(int, input().strip().split())
        find_number_of_k(result[node] ^ k, result)
