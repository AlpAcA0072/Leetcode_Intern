from typing import List

min_len = 100000000


#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
#
# @param reqSkills int整型一维数组 项目需要开发角色的编号
# @param peoSkills int整型二维数组 工程师可以承担的角色
# @return int整型一维数组
#
class Solution:
    def smallestSufficientTeam(
        self, reqSkills: List[int], peoSkills: List[List[int]]
    ) -> List[int]:
        # write code here
        answer = []
        reqSkills.sort()
        for re in reqSkills:
            for ans, skill in enumerate(peoSkills):
                if re in skill:
                    answer.append(ans + 1)
                    # 删掉所有相关数据
                    for idx2, re2 in enumerate(reqSkills):
                        if re2 in skill:
                            reqSkills[idx2] = 0
                    break
        return answer


class Solution:
    def smallestSufficientTeam(
        self, reqSkills: List[int], peoSkills: List[List[int]]
    ) -> List[int]:
        # write code here
        answer = []
        reqSkills.sort()
        for re in reqSkills:
            for ans, skill in enumerate(peoSkills):
                if re in skill:
                    answer.append(ans + 1)
                    # 删掉所有相关数据
                    for idx2, re2 in enumerate(reqSkills):
                        if re2 in skill:
                            reqSkills[idx2] = 0
                    break
        return answer


def rec(add_to, peo):
    pass


# class Solution:
#     def smallestSufficientTeam(
#         self, reqSkills: List[int], peoSkills: List[List[int]]
#     ) -> List[int]:
#         # write code here
#         answer = []
#         reqSkills.sort()
#         for idx, skills in enumerate(peoSkills):
#             intersection = list(set(reqSkills) & set(skills))
#             if intersection != []:
#                 answer.append(idx + 1)
#                 for i in intersection:
#                     reqSkills.remove(i)
#         return answer


s = Solution()
print(s.smallestSufficientTeam([5, 6, 7, 8], [[5], [7, 8], [6, 7, 8]]))
