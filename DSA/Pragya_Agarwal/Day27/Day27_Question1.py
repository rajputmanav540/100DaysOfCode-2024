class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        ele = None
        count =0 
        
        for num in nums:
            if count == 0:
               ele = num
               count += 1
        return ele
