class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        index = {} 
        
        for i in range(len(nums)):
            num = nums[i]  
            val = target - num  
            
            if val in index:
                return [index[val], i]
            index[num] = i
        
        return []
