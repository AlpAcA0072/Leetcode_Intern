first_addr, N, K = input().strip().split()
N = int(N)
K = int(K)
first_addr = str(first_addr)
linked_list = []
input_dict = {}
for i in range(N):
    curr_addr, num, next_addr = map(str, input().strip().split())
    input_dict.update({curr_addr: [num, next_addr]})

curr_addr = first_addr
while True:
    linked_list.append([curr_addr, *input_dict[curr_addr]])
    curr_addr = input_dict[curr_addr][1]
    if curr_addr == "-1":
        break
i = 0
while True:
    start = i * K
    end = start + K - 1
    if end >= len(linked_list):
        break

    linked_list[start : end + 1] = linked_list[start : end + 1][::-1]
    i += 1
for idx, num in enumerate(linked_list):
    if idx != len(linked_list) - 1:
        linked_list[idx][2] = linked_list[idx + 1][0]
    else:
        linked_list[idx][2] = -1

for i in linked_list:
    print(" ".join(map(str, i)))
