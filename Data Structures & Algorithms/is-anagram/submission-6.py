class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        df = {}
        for c in s:
            if df.get(c) is None:
                df[c] = 1
            else:
                df[c] += 1
        
        for c in t:
            if df.get(c) is not None:
                df[c] -= 1
                if df[c] == 0:
                    del df[c]
            else:
                return False
        return len(df) == 0