def count_max(a: str, b: str, char_dict: dict):
    overlap_right = count_overlap(a, b)
    overlap_left = count_overlap(b, a)
    a_nums = []
    a_dict = {}

    for c in a:
        a_dict[c] = a_dict.get(c, 0) + 1

    for i in a:
        a_nums.append(char_dict.get(i, 0) / a_dict[i])
    max_num = min(a_nums)
    for item in a[overlap_left:-overlap_right]:
        char_dict[item] -= max_num

    b_nums = []
    b_dict = {}
    for c in b:
        b_dict[c] = b_dict.get(c, 0) + 1

    for i in b:
        b_nums.append(char_dict.get(i, 0) / b_dict[i])
    max_num += min(b_nums)
    return max_num


def count_overlap(s1: str, s2: str):
    count = 0
    for i in range(len(s1) - 1, -1, -1):
        curr = 0
        temp_count = 0
        while curr < len(s2) and (i + curr) < len(s1) and s2[curr] == s1[i + curr]:
            curr += 1
            temp_count += 1
        if (i + curr) == len(s1):
            count = max(count, temp_count)
    # for i in range(1, max_count + 1):
    #     if s1[-i] == s2[i - 1]:
    #         count += 1
    #     else:
    #         break
    return count


s = str(input()).lower()
a = str(input()).lower()
b = str(input()).lower()
char_dict = {}
for c in s:
    char_dict[c] = char_dict.get(c, 0) + 1

print(int(min(count_max(a, b, char_dict), count_max(b, a, char_dict))))
# print(int(max(count_max(a, b, char_dict), count_max(b, a, char_dict))))
