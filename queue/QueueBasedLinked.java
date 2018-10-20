
/**
 * QueueBasedLinked
 */
public class QueueBasedLinked {

    // 队列的队头和队尾节点
    private Node head = null;
    private Node tail = null;

    /**
     * 入队操作
     * @param value
     */
    public void enqueue(int value) {
        if(tial == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    /**
     * 出队操作
     * @return
     */
    public int dequeue() {
        if(head == null) {
            return -1;
        }

        int value = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return value;
    }

    public static class Node{
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