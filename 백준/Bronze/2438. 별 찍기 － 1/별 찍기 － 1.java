import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String star = "*";

        for(int i = 1; i < n + 1; i++){

            System.out.println(star.repeat(i));
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }


}
