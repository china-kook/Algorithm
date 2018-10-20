import com.sun.org.apache.regexp.internal.recompile;

/**
 * 基于数组的队列
 * 
 * @author ikook
 */
public class ArrayQueue {

    // 数组
    private String[] items;
    // 队列的大小
    private int n;

    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    /**
     * 初始化大小为 capacity 的队列
     * 
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队操作
     * 
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
        // tail == n 表示队尾没有空间
        if (tail == n) {
            return false;
            // head == 0 && tail == n 表示队列满
            if (head == 0) {
                return false;
            }
            // 数据搬移
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            tail = tail - head;
            head = 0;
        }
        itams[tail] = itam;
        ++tail;

        return true;
    }

    /**
     * 出队操作
     * 
     * @return
     */
    public String dequeue() {
        // 队列为空，没有数据
        if (head == tail) {
            return null;
        }
        String result = items[head];
        ++head;

        return result;
    }

}