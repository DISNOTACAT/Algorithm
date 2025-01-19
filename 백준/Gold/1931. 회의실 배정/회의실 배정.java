
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 회의 갯수

        int[][] meeting = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 종료 시간 오름차순, 같으면 시작 시간 오름차순
        Arrays.sort(meeting, Comparator.comparingInt((int[] o) -> o[1])
                                       .thenComparingInt(o -> o[0]));

        int endTime = 0;
        int answer = 0;

        for (int i = 0; i < meeting.length; i++) {
            if (meeting[i][0] >= endTime) {
                endTime = meeting[i][1];
                answer++;
            }
        }

        System.out.println(answer);
    }
}