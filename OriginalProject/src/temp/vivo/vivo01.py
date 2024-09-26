#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 任务分配方案数计算
# @param n int整型 待分配任务总数
# @param x int整型 员工小v能处理的任务数上限
# @param y int整型 员工小i能处理的任务数上限
# @param z int整型 员工小o能处理的任务数上限
# @return int整型
#
class Solution:
    def assignJobs(self, n: int, x: int, y: int, z: int) -> int:
        count = 0
        the_list = []
        for i in range(x + 1):
            for j in range(y + 1):
                for k in range(z + 1):
                    if i + j + k == n:
                        count += 1
                        temp = [i, j, k]
                        temp.sort()
                        the_list.append(tuple(temp))
                        break
        the_list = list(set(the_list))
        return count
        # return len(list(set(the_list)))


s = Solution()
print(s.assignJobs(2, 2, 2, 2))
