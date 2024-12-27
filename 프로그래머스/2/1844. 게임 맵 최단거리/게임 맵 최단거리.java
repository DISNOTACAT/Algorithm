import java.util.*;

class Solution {

    public int solution(int[][] maps) {
        int answer = 0;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] visit = new int[maps.length][maps[0].length];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        visit[0][0] = 1;

        while(!queue.isEmpty()) {

            int[] current = queue.remove();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx < 0 || ny < 0 || nx >= maps.length ||  ny >= maps[0].length) continue;

                if(maps[nx][ny] == 1 && visit[nx][ny] == 0) {
                    queue.add(new int[]{nx, ny});
                    visit[nx][ny] = visit[cx][cy] + 1;
                }

            }
        }

        answer =  visit[maps.length - 1][maps[0].length - 1];

        return answer == 0 ? -1 : answer;
    }
}