import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        int[] dices = new int[3];
        dices[0] = Integer.parseInt(st.nextToken());
        dices[1] = Integer.parseInt(st.nextToken());
        dices[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(dices);

        int money = 0;

        Set<Integer> set = new HashSet<>();
        set.add(dices[0]);
        set.add(dices[1]);
        set.add(dices[2]);


        if(set.size() == 1) {
            money = 10000 + dices[2] * 1000;
        }

        if(set.size() == 3) {
            money = dices[2] * 100;
        }

        if(set.size() == 2) {

            if(dices[0] == dices[1]) {
                money = 1000 + dices[0] * 100;
            } else {
                money = 1000 + dices[2] * 100;
            }

        }

        System.out.println(money);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
