class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        df = dict({})
        for s in strs:
            s_n = "".join(sorted(s))
            if df.get(s_n) is not None:
                df[s_n].append(s)
            else:
                df[s_n] = [s]
        return list(df.values())