class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        df = {}
        for i, n in enumerate(nums):
            print(df.values(), df.keys())
            if (target - n) in df.keys():
                return [df[target - n], i]
            df[n] = i
        return []