import java.io.*;

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(String.valueOf(br.readLine()));
        int num2 = Integer.parseInt(String.valueOf(br.readLine()));

        System.out.println(num1 * (num2%10));
        System.out.println(num1 * (num2%100/10));
        System.out.println(num1 * (num2/100));
        System.out.println(num1 * num2);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
