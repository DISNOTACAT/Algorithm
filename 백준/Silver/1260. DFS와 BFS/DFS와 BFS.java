import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static ArrayList<Integer>[] graph;
    static String dStr = "";
    static String bStr = "";

    static int N;
    static int M;
    static int V;


    public static void dfs(int start, boolean[] visited) {

        dStr += start + " ";
        visited[start] = true;
        int nextV = 0;

        if(!graph[start].isEmpty()) {
            for(int i = 0; i < graph[start].size(); i++) {
                if (!visited[graph[start].get(i)]) {
                    nextV = graph[start].get(i);
                    dfs(nextV, visited);
                }
            }
        }
    }

    public static void bfs(int start, boolean[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            bStr += cur + " ";

            if(!graph[cur].isEmpty()) {
                for(int i = 0; i < graph[cur].size(); i++) {
                    if (!visited[graph[cur].get(i)]) {
                        queue.add(graph[cur].get(i));
                        visited[graph[cur].get(i)] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());   // 정점의 개수
        M = Integer.parseInt(st.nextToken());   // 간선의 개수
        V = Integer.parseInt(st.nextToken());   // 시작 정점

        graph = new ArrayList[N+1];
        boolean[] visited = new boolean[N+1];

        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 양방향 인접리스트 저장
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        for(int i = 0; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        dfs(V, visited);
        System.out.println(dStr.trim());

        Arrays.fill(visited, false);

        bfs(V, visited);
        System.out.println(bStr.trim());

        br.close();
    }
}
