import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        /*  <문제풀이>
            바둑판식으로 종이의 자리를 모두 입력 받고
            중복을 제거하고 입력된 자릿수를 출력하기
         */
        int answer = 0;
        int[][] full = new int[100][100]; // 전체 색종이

        // 입력받은 색종이 모두 합치기
        for (int i = 0; i < n; i++) {
            int a = arr[i][0];  // 왼쪽 아래 모서리 시작 x
            int b = arr[i][1];  // 왼쪽 아래 모서리 시작 y
            for(int j = a; j < a+10; j++){
                for(int k = b; k < b+10; k++){

                    if(full[j][k] != 1){
                        full[j][k] = 1;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

}
