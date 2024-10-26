import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

        public static void solution() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;
            String line;
//            while((line = br.readLine()) != null) {   // NoSuchElementException 발생 EOF를 인지하기 위해 아래와 같이 수정하였다.
            while((line = br.readLine()) != null && !line.isEmpty()) {
                st = new StringTokenizer(line, " ");
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                bw.write(num1 + num2 + "\n");
            }

            bw.flush();
            bw.close();
            br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
