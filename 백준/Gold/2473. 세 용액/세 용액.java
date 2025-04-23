import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        long[] answer = solution(arr);

        Arrays.sort(answer);
        for (long l : answer) {
            System.out.print(l + " ");
        }
    }

    private static long[] solution(long[] arr) {
        int N = arr.length;
        long min = Long.MAX_VALUE;
        long[] answer = new long[3];

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    // sum == 0이면 가장 가까운 값이므로 바로 리턴
                    return new long[]{arr[i], arr[left], arr[right]};
                }
            }
        }
        return answer;
    }
}
