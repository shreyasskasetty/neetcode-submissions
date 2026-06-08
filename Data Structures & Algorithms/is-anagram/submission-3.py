class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        df = dict = ({})
        if len(s) != len(t):
            return False

        for l in s:
            if df.get(l) is not None:
                df[l] += 1
            else:
                df[l] = 1
        
        for l in t:
            if df.get(l) is None:
                return False
            df[l] -= 1
            if df[l] == 0:
                del df[l]
        return len(df) == 0