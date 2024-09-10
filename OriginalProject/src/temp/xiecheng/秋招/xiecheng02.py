def calculate(str: str):
    k = len(str)
    operations = 0
    curr_state = list(str)

    for i in range(k - 1, -1, -1):
        if curr_state[i] == "0":
            operations += 1
            for j in range(i + 1):
                curr_state[j] = "1" if curr_state[j] == "0" else "0"

    return operations


def count_all(str: str):
    n = len(str)
    count = 0

    for start in range(n):
        for end in range(start + 1, n + 1):
            if (end - start) % 2 == 1:
                substring = str[start:end]
                if calculate(substring) % 2 == 1:
                    count += 1

    return count


n = int(input().strip())
str = input().strip()
print(count_all(str=str))
