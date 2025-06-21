import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] remembers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            int count = remembers[i];
            for (int j = 0; j < N; j++) {
                if (answer[j] == 0) {
                    if (count == 0) {
                        answer[j] = i + 1;
                        break;
                    }
                    count--;
                }
            }
        }

        for (int no : answer) {
            System.out.print(no + " ");
        }
    }
}
