# The isBadVersion API is already defined for you.
# @param version, an integer
# @return an integer
# def isBadVersion(version):
#
# Leetcode 278 - First Bad Version
#
# This implementation uses a binary search algorithm to find the first 'Bad Version' of a project.
#
class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        
        if (isBadVersion(1)): return 1
         
        l = 1
        r = n
        
        while l <= r:
            m = (l + r) // 2
            
            if (isBadVersion(m)):
                r = m - 1
            elif isBadVersion(m+1):
                return m+1
            else:
                l = m + 1
                
        return m
        
