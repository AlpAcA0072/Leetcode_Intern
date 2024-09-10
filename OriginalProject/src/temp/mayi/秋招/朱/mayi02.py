import numpy as np


def entropy(y):
    # 计算标签的熵
    _, counts = np.unique(y, return_counts=True)
    probs = counts / len(y)
    result = -np.sum(probs * np.log2(probs))
    return result


def conditional_entropy(feature, label):
    # 计算给定特征的条件熵
    total = len(label)
    values, counts = np.unique(feature, return_counts=True)
    cond_entropy = 0
    for value, count in zip(values, counts):
        subset_label = label[feature == value]
        cond_entropy += (count / total) * entropy(subset_label)
    return cond_entropy


def information_gain(feature, label):
    # 计算信息增益
    return entropy(label) - conditional_entropy(feature, label)


def intrinsic_value(feature):
    # 计算特征的固有值（特征的熵）
    total = len(feature)
    _, counts = np.unique(feature, return_counts=True)
    return -sum((count / total) * np.log2(count / total) for count in counts)


def gain_ratio(feature, label):
    # 计算信息增益比
    gain = information_gain(feature, label)
    iv = intrinsic_value(feature)
    return gain / iv if iv != 0 else 0


def find_best_feature(data):
    # 最后一列是 label
    label = data[:, -1]
    features = data[:, :-1]

    best_feature = -1
    best_gain_ratio = -1

    for i in range(features.shape[1]):
        feature = features[:, i]
        ratio = gain_ratio(feature, label)
        if ratio > best_gain_ratio:
            best_gain_ratio = ratio
            best_feature = i

    return best_feature


# Example usage
data = np.array(
    [
        [0, 0, 0, 0, 0],  # feature1, feature2, feature3, feature4, label
        [0, 0, 0, 1, 0],  # feature1, feature2, feature3, feature4, label
        [0, 1, 0, 1, 1],  # feature1, feature2, feature3, feature4, label
        [0, 1, 1, 0, 0],  # feature1, feature2, feature3, feature4, label
        [0, 0, 0, 0, 0],  # feature1, feature2, feature3, feature4, label
    ]
)

best_feature_index = find_best_feature(data)
print(f"The best feature index is: {best_feature_index}")
