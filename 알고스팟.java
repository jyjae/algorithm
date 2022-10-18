import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class NodeA implements Comparable<NodeA>{
    private int index;
    private int distance;

    public int getIndex() {
        return index;
    }

    public int getDistance() {
        return distance;
    }

    public NodeA(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }

    @Override
    public int compareTo(NodeA o) {
        return this.distance - o.getDistance();
    }
}
public class 알고스팟 {
    private static int n,m, start;
    private static int[][] board;
    private static int[] d;
    private static int[] dx = {1,-1,0,0};
    private static int[] dy = {0,0,1,-1};
    private static ArrayList<ArrayList<NodeA>> graph = new ArrayList<ArrayList<NodeA>>();
    private static PriorityQueue<NodeA> pq = new PriorityQueue<NodeA>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        start = 1;
        board = new int[n][m];
        d = new int[n*m+1];

        Arrays.fill(d, (int)1e9);

        graph.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            String str = br.readLine();
            for(int j=0; j<m; j++) {
                board[i][j] = str.charAt(j)-'0';
                graph.add(new ArrayList<>());
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                for(int k=0; k<dx.length; k++) {
                    int x = i+dx[k];
                    int y = j+dy[k];

                    if(x<0 || y<0 || x>=n ||y>=m) continue;

                    graph.get((i*m+j+1)).add(new NodeA((x*m+y+1),board[x][y]));
                }
            }
        }

        dijkstra(start);

        System.out.println(d[m*n]);

    }

    private static void dijkstra(int start) {
        d[start] = 0;
        pq.offer(new NodeA(start, 0));

        while (!pq.isEmpty()) {
            NodeA node = pq.poll();
            int dst = node.getDistance();
            int now = node.getIndex();

            if(d[now]<dst) continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now]+graph.get(now).get(i).getDistance();

                if(d[graph.get(now).get(i).getIndex()]>cost) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new NodeA(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }
}
