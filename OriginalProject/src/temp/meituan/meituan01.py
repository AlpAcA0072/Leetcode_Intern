str = input()

map_dict = {
    "Q": "P",
    "W": "O",
    "E": "I",
    "R": "U",
    "T": "Y",
    "Y": "T",
    "U": "R",
    "I": "E",
    "O": "W",
    "P": "Q",
    "A": "L",
    "S": "K",
    "D": "J",
    "F": "H",
    "G": "G",
    "H": "F",
    "J": "D",
    "K": "S",
    "L": "A",
    "Z": "M",
    "X": "N",
    "C": "B",
    "V": "V",
    "B": "C",
    "N": "X",
    "M": "Z",
}

str2 = ""
for idx, chr in enumerate(str):
    str2 = str2 + map_dict[chr]

print(str2)
