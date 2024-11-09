    class Solution {
        public static String solution(String s) {
            String answer = "";

            String[] arr = s.split(" ");

            for(String str : arr){
                
                if(str.length() == 0) {
                    answer += " ";
                    continue;
                }
                
                String jaden = str.substring(0,1).toUpperCase();
                String tmp = str.substring(1).toLowerCase();

                str = jaden + tmp;
                answer += str + " ";
            }
            
            if(s.charAt(s.length() - 1) == ' ') return answer;

            return answer.trim();
    }
    }