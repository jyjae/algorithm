import java.util.LinkedList;

public class 연결리스트구현 {
    public static void main(String[] args) {
        NodeMgmt linkedList1 = new NodeMgmt();
        for (int i=1; i<10; i++) {
            linkedList1.add(i);
        }

        linkedList1.add(1, 10);
        linkedList1.add(0,7);
        linkedList1.delete(0);
        linkedList1.delete(10);
        linkedList1.delete(9);
        linkedList1.desc();

    }

}

class NodeC<T> {
    T data;
    NodeC<T> next;

    public NodeC(T data) {
        this.data = data;
        this.next = null;
    }

    public NodeC(T data, NodeC next) {
        this.data = data;
        this.next = next;
    }
}

class NodeMgmt {
    NodeC<Integer> head;

    public NodeMgmt() {
        this.head = new NodeC<>(0);
    }

    /*
     * 1. add(data)
     * 2. add(index, data)
     * 3. remove(data)
     */

    // add(int data)
    public void add(int data) {
        if(head == null) {
            head = new NodeC<>(data);
            return;
        }

        NodeC node = head;
        while (node.next!=null) {
            node = node.next;
        }
        node.next = new NodeC(data);
    }

    public void add(int target, int data) {
        if (head == null) {
            System.out.println("빈값");
            return;
        }

        if (head.data == target) {
            NodeC node = head.next;
            head.next = new NodeC<>(data, node);
        } else {
            NodeC<Integer> node = head;
            while (node.next != null) {
                node = node.next;
                if (node.data == target) {
                    NodeC temp = node.next;
                    node.next = new NodeC(data, temp);
                }
            }
        }
    }

    public void delete(int data) {
        // 1. header 삭제
        if(head.data == data) {
            head = head.next;
        } else {
            NodeC<Integer> node = head;
            while (node.next!=null) {
                if(node.next.data == data) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
        }
    }

    public void desc() {
        if(head==null) {
            System.out.println("빈 값");
            return;
        }

        NodeC node = head;
        while (node!=null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
}




