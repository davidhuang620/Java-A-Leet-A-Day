# There's a more optimized solution to this problem with the quick select approach - (Link)
# For Heap implementation, it is Time O(N * LogK), Space O(K)

# One line 

import heapq
class Solution(object):
    def findKthLargest(self, nums, k):
        return heapq.nlargest(k, nums)[-1]

#####
import heapq
class solution(object):
    def findKthLargest(self, nums, k):
        heapify(nums)
        for i in range(len(nums) - k):
            heappop(nums)
        return heappop(nums)
            
#####
