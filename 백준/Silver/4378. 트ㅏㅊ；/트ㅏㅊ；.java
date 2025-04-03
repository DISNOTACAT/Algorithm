import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final String[] keyboard = {"`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;'", "ZXCVBNM,./"};

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    while(true) {
      String input = br.readLine();

      if(input == null) break;

      for(int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);

        if(c == ' ') {
          System.out.print(c);
          continue;
        }

        for(int keyLine = 0; keyLine < keyboard.length; keyLine++) {
          for(int keys = 1; keys < keyboard[keyLine].length(); keys++) {

            if(c == keyboard[keyLine].charAt(keys)) {
              System.out.print(keyboard[keyLine].charAt(keys-1));
            }
          }
        }
      }

      System.out.println();
    }
  }

}
