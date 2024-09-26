def a_less_than_b(a: list, b: list):
    return a[0] < b[0] and a[1] < b[1] and a[2] < b[2]


def func():
    n = int(input().strip())
    the_list = []
    for _ in range(n):
        the_list.append(list(map(int, input().strip().split())))

    dp = [0] * len(the_list)

    the_list.sort(key=lambda x: (x[0], x[1], x[2]))
    max_height = 0

    for idx, item in enumerate(the_list):
        dp[idx] = item[2]
        for j in range(idx):
            if a_less_than_b(the_list[j], item):
                dp[idx] = max(dp[idx], dp[j] + the_list[idx][2])
        max_height = max(max_height, dp[idx])
    print(max_height)


if __name__ == "__main__":
    func()
