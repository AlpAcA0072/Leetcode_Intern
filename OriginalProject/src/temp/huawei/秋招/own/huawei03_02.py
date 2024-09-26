def check_collison(a: list, b: list):
    return (
        (a[1] > b[0] and a[0] < b[0])
        or (b[1] > a[0] and b[0] < a[0])
        or not (a[0] == b[0] and a[1] == b[1])
    )


def func():
    n = int(input().strip())
    m = int(input().strip())
    values = []
    for i in range(m):
        begin, end, value = map(int, input().strip().split())
        values.append([begin, end, value])
    values.sort(key=lambda x: -x[2])
    result_list = []
    for item in values:
        for ele in result_list:
            if not check_collison(ele, item):
                result_list.append(item)
        if result_list == []:
            result_list.append(item)
    result = 0
    for i in result_list:
        result += i[2]
    print(result)


if __name__ == "__main__":
    func()
