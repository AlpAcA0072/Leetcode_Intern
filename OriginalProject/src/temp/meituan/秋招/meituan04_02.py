import heapq

def find(qs):
    heap = []
    results = []
    for min_value, times in qs:
        index = -1
        end = min_value
        for idx, s in enumerate(heap):
            start = s[0]
            end = s[1]
            total_end = end
            if end >= min_value and start <= min_value:
                min_value = end
                index = idx
                break
        end = end + times
        total_end = end
        results.append(end-1)
        to_remove = []
        if index != -1:
            for ele in heap[index+1:]:
                if ele[1] < total_end:
                    to_remove.append(ele)
            heap[idx] = (heap[idx][0],total_end)
            for ele in to_remove:
                heap.remove(ele)
        else:
            heapq.heappush(heap, (min_value, total_end))
    return results


n = int(input())
qs = []
for i in range(n):
    q = tuple(map(int, input().split()))
    qs.append(q)

results = find(qs)
for i in results:
    print(i)
