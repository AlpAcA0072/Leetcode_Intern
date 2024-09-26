def count_similar_pairs(data, k):
    count_dict = {}
    similar_pairs_count = 0

    for a in data:
        # 检查 a ^ k 是否存在于字典中
        if a ^ k in count_dict:
            similar_pairs_count += count_dict[a ^ k]

        # 更新当前元素 a 的计数
        if a in count_dict:
            count_dict[a] += 1
        else:
            count_dict[a] = 1

    return similar_pairs_count


# 示例数据
data = [1, 4, 3, 1]
k = 5

# 计算相似对数量
result = count_similar_pairs(data, k)
print("Number of similar pairs:", result)
