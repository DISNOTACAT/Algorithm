import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    // BFS 와 메모이제이션을 활용한다.
    // Queue 를 사용하여 익은 토마토를 기준으로 익혀간다. (완전탐색시 시간초과 발생)
    // 토마토가 익는 날짜를 계산하기 위해 시작할 때 1일차부터 시작한다.
    // 토마토가 익을 때 현재 날짜를 저장한다.
    // 익는 토마토를 카운트하여 상태를 반환한다.

    static int days = 0;
    static int[][] tomato;
    static int N;
    static int M;

    static int ripeTomato = 0;
    static Deque<int[]> que = new LinkedList<>();
    static int noneTomato = 0;
    static int totalTomato = 0;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                tomato[i][j] = Integer.parseInt(st.nextToken());

                if(tomato[i][j] == 1){
                    ripeTomato++;
                    que.add(new int[]{i, j});
                } else if(tomato[i][j] == -1){
                    noneTomato++;
                }
            }
        }

        if(ripeTomato + noneTomato == N*M ) {
            System.out.println(0);
            return;
        }

        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++){
                int[] tomato = que.poll();
                bfs(tomato[0], tomato[1]);
            }
            days++;

            if(ripeTomato + noneTomato == N*M) {
                break;
            }
        }
        System.out.println(ripeTomato + noneTomato == N*M ? days : -1);
    }

    private static void bfs(int x, int y) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && tomato[nx][ny] == 0){
                tomato[nx][ny] = 1;
                ripeTomato++;
                que.add(new int[]{nx, ny});
            }
        }
    }
}
