import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class NodeJ implements Comparable<NodeJ>{
    private int index;
    private int distance;

    public NodeJ(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    public int getIndex() {
        return this.index;
    }

    public int getDistance() {
        return this.distance;
    }

    @Override
    public int compareTo(NodeJ o) {
        return this.distance-o.getDistance();
    }
}
public class 전보 {
    private static int n,m,start;
    private static ArrayList<ArrayList<NodeJ>> graph = new ArrayList<ArrayList<NodeJ>>();

    private static int[] d;
    private static PriorityQueue<NodeJ> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        d = new int[n+1];

        Arrays.fill(d, (int) 1e9);

        for(int i=0; i<n+1; i++) {
            graph.add(new ArrayList<NodeJ>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new NodeJ(b,c));
        }

        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int max = Integer.MIN_VALUE;
        for(int i =0; i<d.length; i++) {
            if(i==start) continue;
            if(d[i] != (int)1e9) {
                cnt++;
                if(max<d[i]) max = d[i];
            }
        }

        sb.append(cnt).append(" ").append(max);
        System.out.println(sb.toString());
    }

    private static void dijkstra(int start) {
        d[start] =0;
        pq.offer(new NodeJ(start, 0));

        while (!pq.isEmpty()) {
            NodeJ node = pq.poll();
            int dst = node.getDistance();
            int now = node.getIndex();

            if(d[now]<dst) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now]+graph.get(now).get(i).getDistance();

                if(cost<d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new NodeJ(graph.get(now).get(i).getIndex(), cost));
                }
            }

        }
    }
}
