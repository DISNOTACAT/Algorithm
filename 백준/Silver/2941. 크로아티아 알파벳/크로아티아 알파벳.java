import java.io.*;
import java.util.StringTokenizer;

// 런타임 에러 (StringIndexOutOfBounds)
//public class B2941 {
//
//        public static void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringBuilder str = new StringBuilder(br.readLine());
//        int length = str.length();
//        int idx = 0;
//        int cnt = 0;
//
//        while(idx < length) {
//
//            if(idx == (length - 1)) {
//                cnt++;
//                break;
//            }
//
//            String temp = str.substring(idx,idx+2);
//            switch(temp) {
//                case "c=" :
//                    cnt++; idx +=2; break;
//                case "c-" :
//                    cnt++; idx +=2; break;
//                case "d-" :
//                    cnt++; idx +=2; break;
//                case "lj" :
//                    cnt++; idx +=2; break;
//                case "nj" :
//                    cnt++; idx +=2; break;
//                case "s=" :
//                    cnt++; idx +=2; break;
//                case "z=" :
//                    cnt++; idx +=2; break;
//                case "dz" :
//                    if(str.toString().charAt(idx+2) == '=') {
//                        cnt++; idx +=3;
//                        break;
//                    }
//                default:
//                    cnt++; idx +=1;
//                    break;
//            }
//        }
//
//        System.out.println(cnt);
//
//        bw.flush();
//        bw.close();
//        br.close();
//    }
//
//    public static void main(String[] args) throws IOException {
//        solution();
//    }
//}

public class Main {

        public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder str = new StringBuilder(br.readLine());
        int length = str.length();
        int idx = 0;
        int cnt = 0;

        while(idx < length) {

            if(idx == (length - 1)) {
                cnt++;
                break;
            }

            String temp = str.substring(idx,idx+2);
            switch(temp) {
                case "c=" :
                    cnt++; idx +=2; break;
                case "c-" :
                    cnt++; idx +=2; break;
                case "d-" :
                    cnt++; idx +=2; break;
                case "lj" :
                    cnt++; idx +=2; break;
                case "nj" :
                    cnt++; idx +=2; break;
                case "s=" :
                    cnt++; idx +=2; break;
                case "z=" :
                    cnt++; idx +=2; break;
                case "dz" :
                    if(idx < (length - 2) && str.toString().charAt(idx+2) == '=') {
                        cnt++; idx +=3;
                        break;
                    }
                default:
                    cnt++; idx ++;
                    break;
            }
        }

        System.out.println(cnt);

        bw.flush();
        bw.close();
        br.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
