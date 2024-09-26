from typing import List, Optional
import bisect


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


# solution1 从大到小排列，略快于solution2
def bi_insert(a: List[Optional[ListNode]], x: ListNode):
    hi = len(a)
    lo = 0
    while lo < hi:
        mid = (lo + hi) // 2
        if x.val > a[mid].val:
            hi = mid
        else:
            lo = mid + 1
    a.insert(lo, x)


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lists = [_ for _ in lists if _ != None]
        lists.sort(key=lambda o: -o.val)
        result_prev = ListNode()
        ptr_prev = result_prev

        while lists != []:
            curr = lists.pop()
            ptr_prev.next = curr
            ptr_prev = ptr_prev.next
            if curr.next != None:
                curr = curr.next
                # position = bisect.bisect(lists, curr)
                # lists.insert(position, curr)
                bi_insert(lists, curr)
        return result_prev.next


# solution2 从小到大排列
def bi_insert2(a: List[Optional[ListNode]], x: ListNode):
    hi = len(a)
    lo = 0
    while lo < hi:
        mid = (lo + hi) // 2
        if x.val < a[mid].val:
            hi = mid
        else:
            lo = mid + 1
    a.insert(lo, x)


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        lists = [_ for _ in lists if _ != None]
        lists.sort(key=lambda o: o.val)
        result_prev = ListNode()
        ptr_prev = result_prev

        while lists != []:
            curr = lists.pop(0)
            ptr_prev.next = curr
            ptr_prev = ptr_prev.next
            if curr.next != None:
                curr = curr.next
                # position = bisect.bisect(lists, curr)
                # lists.insert(position, curr)
                bi_insert2(lists, curr)
        return result_prev.next
