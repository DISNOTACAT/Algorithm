import java.io.*;
import java.util.*;

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 0;
        int i = 42;
        Set<Integer> answer = new HashSet<>();

        // 입력되는 한줄이 정수 한 개이기 때문에 StringTokenizer 가 필요하지 않다.
        // 정확한 표현으로는 br.readLine().trim() 으로 작성하여 공백 제거를 해줄 수 있다. 
        while(idx < 10){
            int num = Integer.parseInt(br.readLine());
            answer.add(num%i);

            idx ++;
        }

            System.out.println(answer.size());

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
