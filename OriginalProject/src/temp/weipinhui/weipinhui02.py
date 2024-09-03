import re

seqString = "Runoob"
print(str(list(reversed(seqString))))


def extract_phone_number(phone_str):
    pattern = r"^\d+(-\d+)*\s*#?"
    match = re.match(pattern, phone_str)

    if match:
        return match.group()  # 返回匹配的第一组，即电话号码部分
    else:
        return None  # 如果没有匹配到有效的电话号码，则返回 None


# 测试数据
phone_numbers = [
    "123-456-7890",
    "123-456-7890 # 这是一个注释",
    "1234567890 # 另一个注释",
    "123-456-7890##没有空格的注释",
    "123-456-7890 # 注释中有特殊字符!@#",
]

# 测试
for phone in phone_numbers:
    print(f"Original: {phone}")
    extracted = extract_phone_number(phone)
    print(f"Extracted: {extracted}\n")
