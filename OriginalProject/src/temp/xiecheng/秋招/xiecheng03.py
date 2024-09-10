def generate(result: list, digits: list, curr: list, m):
    if len(curr) == m:
        number = int("".join(map(str, curr)))
        result.append(number)
        return
    for i in range(len(digits)):
        digit = digits[i]

        if len(curr) == 0 and digit == 0 and m > 1:
            continue

        new_digits = digits[:i] + digits[i + 1 :]
        curr.append(digit)
        generate(result=result, digits=new_digits, curr=curr, m=m)
        curr.pop()


def count(n, m, k):
    result = []
    digits = [i for i in range(n + 1)]

    generate(result=result, digits=digits, curr=[], m=m)

    count = sum(1 for num in result if num > k)
    return count


arr = list(map(int, input().strip().split()))
n = arr[0]
m = arr[1]
k = arr[2]
print(count(n, m, k))
