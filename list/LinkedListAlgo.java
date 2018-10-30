
/**
 * 常见的链表操作 1）单链表反转 2）链表中环的检测
 * 3）两个有序的链表合并 4）删除链表倒数第 n 个节点
 * 5）求链表的中间节点
 * 
 * @author ikook
 */
public class LinkedListAlgo {

    /**
     * 单链表反转
     * 
     * @param list
     * @return
     */
    public static Node reverse(Node list) {

        Node headNode = null;
        Node prevNode = null;
        Node currentNode = list;

        while (currentNode != null) {
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = prevNode;
            prevNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;

    }

    /**
     * 单链表节点
     * 
     * @author ikook
     */
    public static class Node {

        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

    }

}
