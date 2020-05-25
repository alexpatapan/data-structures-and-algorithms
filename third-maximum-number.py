"""
Leetcode 414 - Third Maximum Number
"""
import heapq

class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        nums = list(dict.fromkeys(nums))
        heapq.heapify(nums)
        
        if (len(nums) < 3):
            while (len(nums) > 1):
                heapq.heappop(nums)
        
        while (len(nums) > 3):
            heapq.heappop(nums)

        return heapq.heappop(nums)
