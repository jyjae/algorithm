import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Node {
    private int index;
    private int distance;

    public Node(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }
    public int getDistance() {
        return this.distance;
    }
}

public class 다익스트라간단구현 {

    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억 설정
    public static int n, m, start;
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    public static boolean[] visited = new boolean[100001];
    public static int[] d = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node(b,c));
        }

        Arrays.fill(d, INF);

        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i = 1; i <= n; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (d[i] == INF) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(d[i]);
            }
        }


    }

    private static void dijkstra(int start) {
        d[start] =0;
        visited[start] = true;

        for(int j=0; j<graph.get(start).size(); j++) {
            d[graph.get(start).get(j).getIndex()] = graph.get(start).get(j).getDistance();
        }

        for(int i=0; i<n-1; i++) {
            int now = getSmallestNode();
            visited[now] = true;

            for(int j=0; j<graph.get(now).size(); j++) {
                int cost = d[now] +graph.get(now).get(j).getDistance();

                if(cost <d[graph.get(now).get(j).getIndex()]) {
                    d[graph.get(now).get(j).getIndex()] = cost;
                }
            }

        }


    }

    private static int getSmallestNode() {
        int min = INF;
        int index = 0;

        for(int i=0; i<=n; i++) {
            if(d[i]<min && !visited[i]) {
                min = d[i];
                index = i;
            }
        }
        return index;
    }
}
// 시간 복잡도: O(V^2), V는 노드 개수
/*
<입력>
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2

<출력>
0
2
3
1
2
4
 */
