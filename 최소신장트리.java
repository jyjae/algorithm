import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class NodeT implements Comparable<NodeT>{
    private int node1;
    private int node2;
    private int cost;

    public int getNode1() {
        return node1;
    }

    public int getNode2() {
        return node2;
    }

    public int getCost() {
        return cost;
    }

    public NodeT(int node1, int node2, int cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
    }

    @Override
    public int compareTo(NodeT o) {
        return this.cost-o.getCost();
    }
}
public class 최소신장트리 {
    private static ArrayList<NodeT> graph = new ArrayList<>();
    private static int[] parentTable;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        parentTable = new int[V+1];

        for(int i=1; i<parentTable.length; i++) {
            parentTable[i]=i;
        }

        for(int i=0; i<E; i++) {
            graph.add(new NodeT(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(graph);
        int costSum = 0;

        for(int i=0; i<graph.size(); i++) {
            NodeT node = graph.get(i);
            if(union_parent(node.getNode1(), node.getNode2())) costSum +=node.getCost();
        }

        System.out.println(costSum);

    }

    private static boolean union_parent(int node1, int node2) {
        int a = find_parent(node1);
        int b = find_parent(node2);

        if(a<b) parentTable[b] = parentTable[a];
        else if(a>b) parentTable[b] = parentTable[a];
        else return false;

        return true;
    }

    private static int find_parent(int x) {
        if(parentTable[x]!=x) {
            parentTable[x] = find_parent(parentTable[x]);
        }
        return parentTable[x];
    }
}
