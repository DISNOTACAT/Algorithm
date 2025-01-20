
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {

    solution();

  }

  private static void solution() throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int girl = Integer.parseInt(st.nextToken());
    int boy = Integer.parseInt(st.nextToken());
    int intern = Integer.parseInt(st.nextToken());

    int team = 0;
    int rest = 0;
    if(girl + boy <= intern || girl <= 1 || boy == 0) {
      System.out.println(0);
      return;
    }

    if(girl/2 >= boy) {
      team = boy;
      rest = girl - boy*2;
    }
    if(girl/2 < boy) {
      team = girl/2;
      rest = boy - girl/2;
    }

    if(intern > rest) {
      intern -= rest;
      team = team - (intern/3);
      if(intern%3 > 0) {
        team--;
      }
        System.out.println(team);
        return;

    } else {
      System.out.println(team);
      return;
    }
  }
}
