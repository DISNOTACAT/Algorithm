import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        // BFS 탐색, 방문한 곳에 최소값을 저장. 그 중 최대값을 출력한다.
        int answer = 0;

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        Deque<Integer> que = new ArrayDeque<>();
        que.add(1);
        
        int[] depth = new int[n+1];
        int max = 0;
        
        while(!que.isEmpty()) {
            
            int cur = que.poll();
            
            if(!graph[cur].isEmpty()) {
            
                for(int i = 0; i < graph[cur].size(); i++) {
                    
                    int next = graph[cur].get(i);
                    
                    if(next == 1) {
                        continue;
                    }
                    
                    if(depth[next] == 0) {
                        que.add(next);
                        depth[next] = depth[cur] + 1;
                    }
                    
                    if(max < depth[next]) {
                        max = depth[next];
                    }
                }
            }
        }
        
        
        for(int i : depth) {
            if(max == i) {
                answer++;
            }
            
            System.out.println(i);
        }
            System.out.println("max = " + max);
        
        return answer;
    }
}