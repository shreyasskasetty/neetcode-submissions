class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        f = dict({})
        for n in nums:
            if f.get(n) is not None:
                f[n] += 1
            else:
                f[n] = 1
        for k in f.keys():
            if f[k] > 1:
                return True
        return False