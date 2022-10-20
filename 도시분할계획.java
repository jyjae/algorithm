import java.sql.Array;
import java.util.*;

class NodeD implements Comparable<NodeD>{
    private int a;
    private int b;
    private int c;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public NodeD(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public int compareTo(NodeD o) {
        return this.c - o.getC();
    }
}

public class 도시분할계획 {
    private static ArrayList<NodeD> graph= new ArrayList<>();
    private static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        parent = new int[N+1];

        for(int i=1; i<=N; i++) {
            parent[i] = i;
        }



        for(int i=0; i<M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.add(new NodeD(a,b,c));
        }
        Collections.sort(graph);
        int result = 0;
        int last = 0;

        for(int i=0; i<graph.size(); i++) {
            NodeD node = graph.get(i);
            int a = node.getA();
            int b = node.getB();
            int c = node.getC();

            if(union_parent(a,b)) {
                result+= c;
                last = c;
            }
        }

        System.out.println(Arrays.toString(parent));

        System.out.println(result-last);
    }

    private static boolean union_parent(int a, int b) {
        a = find_parent(a);
        b = find_parent(b);

        if(a<b) parent[b] = a;
        else if(a>b) parent[a] = b;
        else if(a==b) return false;

        return true;
    }

    private static int find_parent(int a) {
        if(parent[a] !=a) {
            parent[a] = find_parent(parent[a]);
        }
        return parent[a];
    }
}
