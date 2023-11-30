import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class 이진탐색트리 {
    public static void main(String[] args) {
        TreeMgmt treeMgmt = new TreeMgmt(10);
        treeMgmt.insert(5);
        treeMgmt.insert(12);
        treeMgmt.insert(14);
        treeMgmt.insert(11);

        System.out.println(treeMgmt.head.left.data);
        System.out.println(treeMgmt.head.right.data);
        System.out.println(treeMgmt.head.right.left.data);
        System.out.println(treeMgmt.head.right.right.data);
        System.out.println(treeMgmt.search(5));
        System.out.println(treeMgmt.search(12));
        System.out.println(treeMgmt.search(14));
        System.out.println(treeMgmt.search(15));
        System.out.println(treeMgmt.search(17));


    }

}

class TreeMgmt {
    NodeTree head;
    public TreeMgmt(int data) {
        head = new NodeTree(data);
    }

    public void insert(int data) {
        NodeTree currentNode = head;
        while (true) {
            if(currentNode.data > data) {
                if(currentNode.left!=null) {
                    currentNode = currentNode.left;
                } else {
                    currentNode.left = new NodeTree(data);
                    break;
                }
            } else {
                if(currentNode.right != null) {
                    currentNode = currentNode.right;
                } else {
                    currentNode.right = new NodeTree(data);
                    break;
                }
            }
        }
    }

    public boolean search(int data) {
        NodeTree currentNode = head;
        while (currentNode!=null) {
            if(currentNode.data == data) {
                return true;
            }
            if(currentNode.data > data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public void remove(int data) {
        NodeTree currentNode = head;
        NodeTree parentNode = head;

        boolean checked = false;
        while (currentNode!=null) {
            if(currentNode.data == data) {
                checked = true;
                break;
            }
            if(currentNode.data>data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
            }
        }

        if(!checked) return;

        // 삭제할 노드가 leaf node일 경우
        if(currentNode.left == null && currentNode.right == null) {
            if(currentNode.data < parentNode.data) {
                currentNode.left = null;
            }else {
                currentNode.right=null;
            }
        }

        // 삭제할 노드 자식 노드가 하나일경우
        // 삭제할 노드에 왼쪽 자식노드가 있을경우
        if(currentNode.left!=null && currentNode.right==null) {
            // 삭제할 노드가 부모노드의 왼쪽 노드일 경우
            if(parentNode.data> currentNode.data) {
                parentNode.left = currentNode.left;
            }else {
                // 삭제할 노드가 부모노드의 오른쪽 노드일 경우
                parentNode.right = currentNode.left;
            }
        } else if(currentNode.left==null && currentNode.right!=null){
            // 삭제할 노드에 오른쪽 자식노드가 있을경우
            // 삭제할 노드가 부모노드의 왼쪽 노드일 경우
            if(parentNode.data> currentNode.data) {
                parentNode.left = currentNode.right;
            }else {
                // 삭제할 노드가 부모노드의 오른쪽 노드일 경우
                parentNode.right = currentNode.right;
            }
        } else if(currentNode.left!=null && currentNode.right != null) {
            NodeTree changeNode = currentNode.right;
            NodeTree changeParentNode = currentNode.right;

            while (changeNode.left!=null) {
                changeParentNode = changeNode;
                changeNode = changeNode.left;
            }

            if(changeNode.right!=null) {
                changeParentNode.left = changeNode.right;
            } else {
                changeParentNode.left = null;
            }

            if(parentNode.data > currentNode.data) {
                parentNode.left = changeNode;

            }else {
                parentNode.right = changeNode;
            }

            changeNode.left = currentNode.left;
            changeNode.right = currentNode.right;
        }

    }
}

class NodeTree {
    int data;
    NodeTree left;
    NodeTree right;

    public NodeTree(int data) {
        this.data = data;
    }
}
