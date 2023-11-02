import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class 풍선터뜨리기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        Deque queue = new ArrayDeque();
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < size; i++) {
            queue.add(new Node(Integer.parseInt(input[i]), i));
        }

        Node target = (Node) queue.poll();
        StringBuffer sb = new StringBuffer();
        sb.append(1).append(" ");

        while (!queue.isEmpty()) {
            if (target.data > 0) {
                for (int i = 0; i < target.data - 1; i++) {
                    queue.add(queue.poll());
                }
                target = (Node) queue.poll();
            } else {
                for (int i = 0; i < -(target.data + 1); i++) {
                    queue.addFirst(queue.pollLast());
                }
                target = (Node) queue.pollLast();
            }

            sb.append(target.index+1).append(" ");
        }

        System.out.println(sb.toString());
    }

    public static class Node {

        int data;
        int index;

        public Node(int data, int index) {
            this.data = data;
            this.index = index;
        }
    }
}