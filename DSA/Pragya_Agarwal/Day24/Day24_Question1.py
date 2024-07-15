class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
       N = len(nums)                
       result = [0] * N                
       for i in range(N):             
        result[i] = nums[i] * nums[i]  
            
       result.sort()                   
       return result
