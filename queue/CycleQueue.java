
/**
 * 循环队列
 * 
 * @author ikook
 */
public class CycleQueue {

    private String[] items;
    private int n;

    private int head;
    private int tail;

    public CycleQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     * 
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // 队列满
        if ((tail + 1) % n == head) {
            return null;
        }
        items[tail] = item;
        tail = (tail + 1) % n;

        return true;
    }

    /**
     * 出队
     * @return
     */
    public String dequeue() {
        if (head == tail) {
            return null;
        }

        String value = items[head];
        head = (head + 1) % n;

        return value;
    }

}