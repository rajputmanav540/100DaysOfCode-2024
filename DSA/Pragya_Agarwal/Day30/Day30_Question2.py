class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        max_val = nums[0]
        index = 0
        
        for i in range(1, len(nums)):
            if nums[i] > max_val:
                max_val = nums[i]
                index = i
        for i in range(len(nums)):
            if i != index and max_val < 2 * nums[i]:
                return -1
        return index
