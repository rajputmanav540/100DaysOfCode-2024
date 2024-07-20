class Solution:
    def majorityElement(self, nums: List[int]) -> List[int]:
        ele1 = None
        ele2 = None
        count1 = 0
        count2 = 0 
        
        for num in nums:
            if num == ele1:
                count1 += 1
            elif num == ele2:
                count2 += 1
            elif count1 == 0:
                ele1, count1 = num, 1
            elif count2 == 0:
                ele2, count2 = num, 1
            else:
                count1 -= 1
                count2 -= 1
        
        count1, count2 = 0, 0
        for num in nums:
            if num == ele1:
                count1 += 1
            elif num == ele2:
                count2 += 1
        
        result = []
        n = len(nums)
        if count1 > n // 3:
            result.append(ele1)
        if count2 > n // 3:
            result.append(ele2)
        
        return result
