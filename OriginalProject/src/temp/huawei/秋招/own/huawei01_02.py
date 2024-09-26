import sys

the_map = []


def BFS(r: int, c: int, dises: list):
    dis = 0
    queue = []
    queue.append((r, c))
    dises[r][c] = 0
    while queue != []:
        dis += 1
        next_layer = []
        while queue != []:
            # 否则pop(0)
            r, c = queue.pop()
            # up
            if r - 1 >= 0 and the_map[r - 1][c] != -1 and the_map[r - 1][c] != 0:
                if dises[r - 1][c] > dis:
                    dises[r - 1][c] = dis
                    next_layer.append((r - 1, c))
            # down
            if (
                r + 1 < len(dises)
                and the_map[r + 1][c] != -1
                and the_map[r + 1][c] != 0
            ):
                if dises[r + 1][c] > dis:
                    dises[r + 1][c] = dis
                    next_layer.append((r + 1, c))
            # left
            if c - 1 >= 0 and the_map[r][c - 1] != -1 and the_map[r][c - 1] != 0:
                if dises[r][c - 1] > dis:
                    dises[r][c - 1] = dis
                    next_layer.append((r, c - 1))
            # right
            if (
                c + 1 < len(dises[0])
                and the_map[r][c + 1] != -1
                and the_map[r][c + 1] != 0
            ):
                if dises[r][c + 1] > dis:
                    dises[r][c + 1] = dis
                    next_layer.append((r, c + 1))
        queue = next_layer
        # 很关键
        queue.reverse()


def func():
    m, n = map(int, input().strip().split())
    for _ in range(m):
        the_map.append(list(map(int, input().strip().split())))

    dises = []
    for _ in range(m):
        dises.append([sys.maxsize] * n)

    for r, row in enumerate(the_map):
        for c, _ in enumerate(row):
            if the_map[r][c] == 0:
                BFS(r, c, dises)
    count = 0
    for r, row in enumerate(the_map):
        for c, value in enumerate(row):
            if value == 1:
                count += dises[r][c] if dises[r][c] != sys.maxsize else 0
    print(count)

    # please finish the function body here.
    # please define the python3 output here. For example: print().


if __name__ == "__main__":
    func()
