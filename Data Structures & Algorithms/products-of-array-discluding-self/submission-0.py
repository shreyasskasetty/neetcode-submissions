class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        rArr = [1]
        lArr = [1]
        rProd = 1
        n = len(nums)
        lProd = 1
        for i in range(1, len(nums)):
            rProd = nums[i - 1] * rProd
            lProd = nums[n - i] * lProd
            rArr.append(rProd)
            lArr.append(lProd)
        lArr.reverse()
        res = []
        for i in range(len(lArr)):
            res.append(lArr[i] * rArr[i])
        return res

            
