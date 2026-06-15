class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        bucket = set()
        for n in nums:
            bucket.add(n)
        res = []
        maxRes = 0
        for n in nums:
            i = n
            temp = []
            while i in bucket:
                temp.append(i)
                i = i + 1
            maxRes = max(maxRes, len(temp))
        return maxRes