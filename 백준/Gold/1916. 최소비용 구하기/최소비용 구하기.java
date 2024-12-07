import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
* https://velog.io/@suk13574/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98Java%EB%8B%A4%EC%9D%B5%EC%8A%A4%ED%8A%B8%EB%9D%BCDijkstra-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
* <<< 다익스트라 알고리즘 >>>
* BFS와 차이는 가중치 그래프에 사용한다.
* 우선순위 큐를 사용하여 개선된 다익스트라 알고리즘을 사용할 수 있음.
* 음수 간선 없어야 한다.
* 인접 리스트로 구현
* 시간 복잡도 : O(ElogV) -> v 노드 수 / e 에지수
*
* <<< 우선순위 큐 >>>
* 일반적인 FIFO 구조를 가지지만 순서대로 나가는 것이 아닌 우선순위가 높은 데이터가 먼저 나가는 구조
* 우선 순위 큐에 저장할 객체는 Camparable Interface를 구현해야한다.
* override 한 compareTo 메서드에서 우선순위 조건을 리턴시킨다.
* Heap 을 이용하여 구현한다.
* 시간복잡도 : O(NLogN)
*
* https://velog.io/@gillog/Java-Priority-Queue%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84-%ED%81%90
* <<< 우선순위 큐 선언 >>>
* import java.util.PriorityQueue;
* import java.util.Collections;
* //낮은 숫자가 우선 순위인 int 형 우선순위 큐 선언
* PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
* //높은 숫자가 우선 순위인 int 형 우선순위 큐 선언
* PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
*
* <<< 큐의 명령어 >>>
* add(value)   : 삽입에 성공하면 true를 반환, 큐에 공간이 부족할 경우 예외발생
* offer(value) : 삽입에 성공하면 true를 반환, 큐에 공간이 부족할 경우 false
* poll()       : 첫번째 값을 반환하고 제거 비어있다면 null
* remove()     : 첫번째 값을 제거 비어있다면 예외발생
* peek()       : 첫번째 값을 반환만. 큐가 비어있다면 null
* element()    : 천번째 값을 반환만. 큐가 비어있다면 예외 발생
* clear()      : 초기화
*
*
* https://innovation123.tistory.com/111
* <<< Heap >>>
* 완전 이진 트리 형태로 최대,최소값을 빠르게 찾아내는데 유용한 자료구조
* (이진 트리 : 모든 노드는 둘 이하의 자식을 가진다.)
* (완전 이진 트리 : 마지막 레벨을 제외하고 노드들이 가득 차있는 트리)
* 중복값 허용, 부모자식의 정렬은 보장하지만 형제의 정렬은 보장하지 않는다.
* 최소 힙 : 루트노드가 최솟값이 되고, 부모노드의 key는 자식 노드의 key 보다 작아야 한다
* -> 최소 힙의 삽입 과정 : 트리 가장 끝에 데이터를 삽입, 부모 노드와 비교하며 작을 경우 자리를 부모와 교체
* -> 최소 힙의 삭제 과정 : 최상위 노드를 삭제한 후 트리 가장 끝에 있는 데이터를 최상위에 위치 시키고 재정렬.
* 최대 힙 : 루트노드가 최댓값이 되고, 부모노드의 key가 자식 노드의 key 보다 커야 한다.
*
* <<< 다익스트라 구현 방법 >>>
* 1) 아직 방문하지 않은 정점 중 출발지로 부터 가장 거리가 짧은 정점을 방문한다.
* 2) 해당 정점을 거쳐 갈 수 있는 정점의 거리가 이전 기록한 값보다 작으면 갱신한다.
*

 * */

public class Main {

    // 이너 클래스로 노드를 생성해주었다. 우선순위 큐로 생성하였다.
    public static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }

    // 문제풀이
    public static void main(String[] args) throws IOException {

        /*
            입력값 저장
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(br.readLine()); // 도시는 정점이 된다.
        int edge = Integer.parseInt(br.readLine()); // 버스는 에지가 된다.

        // 노드를 리스트로 저장
        ArrayList<Node>[] graph = new ArrayList[node + 1];

        // 배열의 각 요소 초기화
        for (int i = 0; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }

        // 버스 경로 = 그래프 입력 받기
        StringTokenizer st;
        for(int i = 0; i < edge; i++){

            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }
        // 출발점과 종료점 설정
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        /*
            우선순위 큐 준비
         */
        // 각 도시의 방문 정보를 저장할 배열을 선언
        boolean[] check = new boolean[node + 1];
        int[] dist = new int[node + 1];

        // dist 의 모든 값을 무한대로 초기화 한다. 제일 작은 수와 비교하기 위함
        int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        // 출발점 초기화
        dist[start] = 0;

        // 버스 정점과 가중치를 저장할 우선순위 큐 선언 및 시작점 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        // 우선순위 반복
        while(!pq.isEmpty()){

            int nowVertex = pq.poll().index;    // 큐 안에 있는 노드 중 가장 작은 cost 의 index 반환

            if(check[nowVertex]) continue;  // 확인 한 노드면 지나감
            check[nowVertex] = true;        // 확인 하지 않은 노드면, 확인완료 처리 후 검증 시작

            // 현재 정점(index)의 연결된 간선들을 모두 비교하여 업데이트
            for(Node next : graph[nowVertex]){
                if(dist[next.index] > dist[nowVertex] + next.cost){ // 저장된 값이 가중치 합보다 크다면 작은 값으로 업데이트
                    dist[next.index] = dist[nowVertex] + next.cost;
                    pq.offer(new Node(next.index, dist[next.index]));  // 작은 노드 정보만 큐에 추가
                }

            }
        }

        /*
            dist[] 배열은 start 에서 모든 정점까지의 각 최단거리가 저장됨.
            이중 end 로 가는 최단거리를 출력
         */
        System.out.print(dist[end]);
        br.close();
    }
}
