# 
# Leetcode 199 - Binary Tree Right Side View
#
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        result = list()
    
        if root is None:
            return result
        
        queue = list()
        queue.append(root)
        # perform breadth first search -> queue 
        count = 1
        while (len(queue) != 0):
            
            node = queue.pop(0)
            count -= 1
            
            if not (node.left is None):
                queue.append(node.left)
            if not (node.right is None):
                queue.append(node.right)
            
            if (count == 0):
                # we have finished a level
                result.append(node.val)
                count = len(queue)
                
        return result
