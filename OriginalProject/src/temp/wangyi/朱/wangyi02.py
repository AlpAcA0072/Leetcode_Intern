arr = list(input().strip())
stack = []

# new_str = ""
# for c in arr:
#     if c != "(" and c != ")":
#         stack.append(c)
#     else:
#         if c == "(":
#             stack.append(c)
#         else:
#             if stack != []:
#                 if "(" in stack:
#                     while True:
#                         curr_c = stack.pop()
#                         new_str += curr_c
#                         if curr_c == "(":
#                             break
#                     new_str += c
# print(new_str)


stack = []
remove = set()  # 使用集合存储需要移除的索引
for idx, c in enumerate(arr):
    if c == "(":
        stack.append(idx)
    elif c == ")":
        if stack:
            stack.pop()
        else:
            remove.add(idx)

# 将剩余未匹配的 '(' 的索引加入需要移除的集合
remove.update(stack)

# 构建结果字符串
print("".join([ch for i, ch in enumerate(arr) if i not in remove]))
