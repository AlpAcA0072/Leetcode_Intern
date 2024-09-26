from typing import List, Optional
import bisect


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
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
                bisect.insort(lists, curr)
        return result_prev.next
