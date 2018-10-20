
/**
 * 用数组实现的简单栈
 * 
 * @author ikook
 */
public class ArrayStack {

    private String[] items; // 数组
    private int count; // 栈中元素的个数
    private int size; // 栈的大小

    // 初始化数组，申请一个大小为 n 的数组空间
    public ArrayStack(int n) {
        this.items = new String[n];
        this.count = 0;
        this.size = n;
    }

    /**
     * 入栈操作
     * 
     * @param item
     * @return
     */
    public boolean push(String item) {
        // 数组空间不够用了， 直接返回 false，入栈失败
        if (count == size) {
            return false;
        }

        // 将 item 放到下标为 count 的位置，并将 count 加 1
        items[count] = item;
        ++count;
        return true;
    }

    /**
     * 出栈操作
     * 
     * @return
     */
    public String pop() {
        // 栈为空，则直接返回 null;
        if (count == 0) {
            return null;
        }

        // 返回下标为 count-1 的数组元素，并且栈中元素个数减一
        String temp = items[count - 1];
        --count;
        return temp;
    }

    /**
     * 获取元素个数
     * 
     * @return
     */
    public int getSize() {
        return count;
    }

    /**
     * 判断是否为空
     * 
     * @return
     */
    public boolean isEmpty() {
        return count == 0;
    }

}