def func():
    n = int(input().strip())
    m = int(input().strip())
    values = []
    qujians = []
    for i in range(m):
        begin, end, value = map(int, input().strip().split())
        qujians.append([begin, end, value])
        values.append([0] * (n + 1))
        for j in range(begin, end):
            values[i][j] = value
    dp = [0] * (n + 1)
    qujian = []
    for i in range(1, len(dp)):
        max_value = max(dp[:, i : i + 1])

        if qujian !=[] and qujian[-1][1] >=


if __name__ == "__main__":
    func()
