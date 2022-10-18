import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Node1 {
    private int index;
    private int distance;

    public Node1(int index, int distance) {
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
public class 다익스트라우선순위큐 {
    private static final int INF = (int) 1e9;
    private static int n,m,start;

    private static ArrayList<ArrayList<Node1>> graph = new ArrayList<ArrayList<Node1>>();
    private static PriorityQueue<Node1> queue = new PriorityQueue<Node1>((Node1 o1, Node1 o2) -> o1.getDistance()-o2.getDistance());
    private static int[] d = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node1>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Node1(b,c));
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
        d[start] = 0;
        queue.offer(new Node1(start,0));

        while (!queue.isEmpty()) {
            Node1 node = queue.poll();

            int dst = node.getDistance();
            int now = node.getIndex();

            if(d[now] < dst) continue;

            for(int i =0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(d[graph.get(now).get(i).getIndex()] > cost) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    queue.offer(new Node1(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }

    }
}
