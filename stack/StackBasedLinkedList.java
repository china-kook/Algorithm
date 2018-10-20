
/**
 * 基于链表实现的栈
 * 
 * @author ikook
 */
public class StackBasedLinked {

    private Node top = null;
    private int size = 0;

    /**
     * 入栈操作
     * 
     * @param value
     */
    public void push(int value) {
        Node newNode = new Node(value, null);

        // 判断栈是否为空
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        ++size;
    }

    /**
     * 出栈操作，-1 表示没有数据
     * 
     * @return
     */
    public int pop() {
        if (top == null) {
            return -1;
        }

        int value = top.data;
        top = top.next;

        --size;

        return value;
    }

    /**
     * 栈的大小
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 栈是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

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