#
# 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
#
# 计算出最佳的战斗次数
# @param S_num int整型 兽族部落人数
# @param J_num int整型 精灵部落人数
# @param W_num int整型 巫族部落人数
# @return int整型
#
class Solution:
    def calc_best_fight_num(self, S_num: int, J_num: int, W_num: int) -> int:
        the_list = [S_num, J_num, W_num]
        the_list.sort()
        return the_list[1] if (the_list[1] - the_list[0]) % 2 == 0 else the_list[2]


s = Solution()
print(s.calc_best_fight_num(3, 7, 10))
print(s.calc_best_fight_num(3, 6, 10))
