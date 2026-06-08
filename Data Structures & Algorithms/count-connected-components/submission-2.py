from collections import defaultdict
class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adj = defaultdict(list)
        for i in range(len(edges)):
            adj[edges[i][0]].append(edges[i][1])
            adj[edges[i][1]].append(edges[i][0])
        
        visited = [0] * n
        def dfs(v):
            visited[v] = 1
            for n in adj[v]:
                if visited[n] != 1:
                    dfs(n)
        count = 0
        for i in range(n):
            if visited[i] != 1:
                dfs(i)
                count += 1
        return count