import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {

    static int[][] map;
    static int M, N, K;

    /* 상, 하, 좌, 우 를 나타내기 위한 x, y 좌표 */
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};


    public static boolean dfs(int x, int y) {
        /*
            현재 위치에 배추가 없으면 false 반환
            현재 위치에 배추가 있으면 (=1), 0으로 치환 + 아래 로직 처리 후 true 반환  -> 하나의 배추 묶음

            현재 자리에서 상,하,좌,우 방향으로 확인
            해당 자리에 배추가 있으면 (=1), 0으로 치환
         */
        if(x < 0 || y < 0 || x >= M || y >= N) return false;

        if(map[x][y] == 1) {
            map[x][y] = 0;  // 배추 없애버림

            for (int i = 0; i < 4; i++) {
                dfs(x + dx[i], y + dy[i]);  // 사방을 순회하며 연결된 배추들을 0처리
            }
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // 케이스의 갯수

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());   // 밭의 가로
            N = Integer.parseInt(st.nextToken());   // 밭의 세로
            K = Integer.parseInt(st.nextToken());   // 배추의 수

            map = new int[M][N];

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            // 각 테스트 진행
            int answer = 0;
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(dfs(i,j)) {  // 각 자리마다 배추 묶음 찾고 돌아옴. 배추 없는 자리면 false
                        answer++;
                    }
                }
            }

            System.out.println(answer);
        }

        br.close();
    }
}
