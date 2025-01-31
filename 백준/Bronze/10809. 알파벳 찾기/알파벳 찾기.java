import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

  static HashMap<Character, Integer> alphabetMap;

  public static void main(String[] args) throws IOException {
    solution();
  }

  private static void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s  = br.readLine();

    alphabetMap = new HashMap<>();
    generateAlphabet();

    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);

      if(alphabetMap.get(c) == -1) {
        alphabetMap.put(c, i);
      }
    }

    printAlphabet();
  }

  private static void printAlphabet() {
    StringBuilder sb = new StringBuilder();
    sb.append(alphabetMap.get('a')).append(" ");
    sb.append(alphabetMap.get('b')).append(" ");
    sb.append(alphabetMap.get('c')).append(" ");
    sb.append(alphabetMap.get('d')).append(" ");
    sb.append(alphabetMap.get('e')).append(" ");
    sb.append(alphabetMap.get('f')).append(" ");
    sb.append(alphabetMap.get('g')).append(" ");
    sb.append(alphabetMap.get('h')).append(" ");
    sb.append(alphabetMap.get('i')).append(" ");
    sb.append(alphabetMap.get('j')).append(" ");
    sb.append(alphabetMap.get('k')).append(" ");
    sb.append(alphabetMap.get('l')).append(" ");
    sb.append(alphabetMap.get('m')).append(" ");
    sb.append(alphabetMap.get('n')).append(" ");
    sb.append(alphabetMap.get('o')).append(" ");
    sb.append(alphabetMap.get('p')).append(" ");
    sb.append(alphabetMap.get('q')).append(" ");
    sb.append(alphabetMap.get('r')).append(" ");
    sb.append(alphabetMap.get('s')).append(" ");
    sb.append(alphabetMap.get('t')).append(" ");
    sb.append(alphabetMap.get('u')).append(" ");
    sb.append(alphabetMap.get('v')).append(" ");
    sb.append(alphabetMap.get('w')).append(" ");
    sb.append(alphabetMap.get('x')).append(" ");
    sb.append(alphabetMap.get('y')).append(" ");
    sb.append(alphabetMap.get('z'));

    System.out.println(sb);
  }

  private static void generateAlphabet() {

    alphabetMap.clear();
    alphabetMap.put('a', -1);
    alphabetMap.put('b', -1);
    alphabetMap.put('c', -1);
    alphabetMap.put('d', -1);
    alphabetMap.put('e', -1);
    alphabetMap.put('f', -1);
    alphabetMap.put('g', -1);
    alphabetMap.put('h', -1);
    alphabetMap.put('i', -1);
    alphabetMap.put('j', -1);
    alphabetMap.put('k', -1);
    alphabetMap.put('l', -1);
    alphabetMap.put('m', -1);
    alphabetMap.put('n', -1);
    alphabetMap.put('o', -1);
    alphabetMap.put('p', -1);
    alphabetMap.put('q', -1);
    alphabetMap.put('r', -1);
    alphabetMap.put('s', -1);
    alphabetMap.put('t', -1);
    alphabetMap.put('u', -1);
    alphabetMap.put('v', -1);
    alphabetMap.put('w', -1);
    alphabetMap.put('x', -1);
    alphabetMap.put('y', -1);
    alphabetMap.put('z', -1);

  }

}
