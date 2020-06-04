#
# Leetcode 79 - Word Search
#
class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        self.visited = set()
        flag = False
        
        # search through board -> if we find first letter call function 
        for i in range(len(board)):
            for j in range(len(board[i])):
                if (board[i][j] == word[0]):
                    self.visited.clear()
                    self.visited.add((i, j))
                    flag = self.search(board, word, 1, (i, j)) or flag
        return flag  
    
    def search(self, board, word, n, pos):
        if (n == len(word)):
            return True
        flag = False
        directions = [[1, 0], [0, 1], [-1, 0], [0, -1]]
        
        for direc in directions:
            i = pos[0] + direc[0]
            j = pos[1] + direc[1]
            
            if ((i, j) in self.visited):
                continue
                
            if (i >= len(board) or i < 0 or j >= len(board[0]) or j < 0):
                continue
            
            if (board[i][j] == word[n]):
                
                self.visited.add((i, j))
                flag = self.search(board, word, n + 1, (i, j)) or flag
                if not flag:
                    self.visited.remove((i, j))

        return flag
            
