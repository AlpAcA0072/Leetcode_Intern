def can_compare(a: list, b: list):
    if a[0] < b[0] and a[1] < b[1] and a[2] < b[2]:
        return True
    if a[0] > b[0] and a[1] > b[1] and a[2] > b[2]:
        return True
    return False


def func():
    n = int(input().strip())
    the_list = []
    for _ in range(n):
        the_list.append(list(map(int, input().strip().split())))
    result_list = []
    while the_list != []:
        item = the_list.pop()
        temp = []
        temp.append(item)
        for i in range(len(the_list)):
            if not can_compare(item, the_list[i]):
                temp.append(the_list.pop(i))
        result_list.append(temp)

    result = 0
    for group in result_list:
        max_height = 0
        for item in group:
            max_height = max(max_height, item[2])
        result += max_height
    print(result)


if __name__ == "__main__":
    func()
