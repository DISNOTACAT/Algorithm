import java.util.*;
import java.io.*;

public class Main {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //솔루션 코드 작성
        int n = Integer.parseInt(br.readLine());
        int kg = 0;

        /*
            1. 5로 나눠 떨어지는 경우
            2. 3과 5로 조합하여 담는 경우
            3. 3으로 나눠지는 경우
            4. 나눌 수 없는 경우.

            나머지는 항상 0~4가 나옵니다.
            3-> 1개
            1-> 6키로로 해결하니 +1개
            2 -> 12키로로 해결해야하니 -2개 + 4개 즉 +2개
            4 -> 3+6키로로 해결해야하니 -1개 + 3개 즉 +2개
            -1 이 나오는 경우
            4,7
         */
        if(n == 4 || n == 7) {
            kg = -1;
        } else if (n % 5 == 0) {
            kg = n / 5;
        } else if (n % 5 == 1 || n % 5 == 3) {
            kg = (n / 5) + 1;
        } else {
            kg = (n / 5) + 2;
        }

        bw.write(String.valueOf(kg));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}