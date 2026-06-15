class Solution:
    def isPalindrome(self, s: str) -> bool:
        reducedS = ""
        for x in s:
            if x.isalnum():
                reducedS += x.lower()
        print(reducedS)
        print(len(reducedS))
        for i in range(len(reducedS)//2):
            if reducedS[i] != reducedS[len(reducedS) - i - 1]:
                print(reducedS[i],reducedS[len(reducedS) - i - 1])
                return False
        return True