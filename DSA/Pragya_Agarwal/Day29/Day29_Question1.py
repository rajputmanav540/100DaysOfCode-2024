class Solution:
    def maxChunksToSorted(self, arr: List[int]) -> int:
        n = len(arr)
        chunks = 0
        max_val = -1
    
        for i in range(n):
            max_val = max(max_val, arr[i])
            if i == max_val:
               chunks += 1
    
        return chunks
