import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[3];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int A  = arr[0];
        int B  = arr[1];
        int C  = arr[2];

            System.out.println((A+B)%C);
            System.out.println(((A%C) + (B%C))%C);
            System.out.println((A*B)%C);
            System.out.println(((A%C) * (B%C))%C);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
