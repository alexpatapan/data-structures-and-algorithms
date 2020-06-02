# 
# Leetcode 366 - Find Leaves of Binary Tree
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def findLeaves(self, root: TreeNode) -> List[List[int]]:
        self.count = 0
        result = list()
        result.append(list())
        
        if (root is None):
            return list()
        
        self.dfs(root, result)
        
        return result
        
    def dfs(self, node, result):
        if (node.left is None and node.right is None):
            result[0].append(node.val)
            return 0
       
        if not (node.left is None):
            a = self.dfs(node.left, result)
        else:
            a = 0
            
        if not (node.right is None):
            b = self.dfs(node.right, result)
        else:
            b = 0
        
        # we are at bottom of tree
        
        while (len(result) <= max(a,b)+1):
            result.append(list())
            
        result[max(a,b)+1].append(node.val)
        return max(a,b)+1
            
            
            
        
