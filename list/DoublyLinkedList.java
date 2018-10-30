package linkedlist;

import java.util.*;
/**
 * 实现双向链表
 * 
 * @author ikook
 */
public class DoublyLinkedList {

    private Node first;
    private Node last;
    private int size; // 长度

    /**
     * 在链表头部插入新的元素
     */
    public void addFirst(Object value) {

        Node f = first;
        Node newNode = new Node(null, value, f);

        first = newNode;

        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }

        ++size;
    }

    /**
     * 在链表尾部插入新的元素
     */
    public void addLast(Object value) {
        Node l = last;
        Node newNode = new Node(l, value, null);

        last = newNode;

        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }

        ++size;
    }

    /**
     * 在链表中插入新的元素，默认插入到链表尾部
     */
    public void add(Object value) {
        addLast(value);
    }

    public void add(int index, Object value) {
        checkPositionIndex(index);

        if (index == size) {
            addLast(value);
        } else {

            Node temp = currentIndexNode(index);
            Node prev = temp.prev;

            Node newNode = new Node(prev, value, temp);
            temp.prev = newNode;
            if (prev == null) {
                first = newNode;
            } else {
                prev.next = newNode;
            }

            ++size;
        }
    }

    /**
     * 获取 list 的大小
     */
    public int size() {
        return size;
    }

    /**
     * 判断 list 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取链表头部的元素
     */
    public Object getFirst() {

        Node f = first;
        if (f == null) {
            throw new NoSuchElementException("链表为空，没有头节点");
        }

        return f.data;
    }

    /**
     * 获取链表尾部的元素
     */
    public Object getLast() {
        Node l = last;
        if (l == null) {
            throw new NoSuchElementException("链表为空，没有尾节点");
        }
        return l.data;
    }

    /**
     * 获取指定位置的元素
     */
    public Object get(int index) {
        checkElementIndex(index);

        return currentIndexNode(index).data;
    }

    /**
     * 删除链表头部元素
     */
    public Object removeFirst() {

        Node f = first;

        if (f == null) {
            throw new NoSuchElementException("链表为空，没有头节点");
        }

        Object element = f.data;
        Node next = f.next;

        f.data = 0;
        f.next = null;

        first = next;

        if (next == null) {
            last = null;
        } else {
            next.prev = null;
        }

        --size;

        return element;
    }

    /**
     * 删除链表尾部的元素
     */
    public Object removeLast() {

        Node l = last;
        if (l == null) {
            throw new NoSuchElementException("链表为空，没有尾节点");
        }

        Object element = l.data;
        Node prev = l.prev;

        l.prev = null;
        l.data = 0;

        last = prev;

        if (prev == null) {
            first = null;
        } else {
            prev.next = null;
        }

        --size;

        return element;
    }

    /**
     * 删除指定元素的节点
     */
    public boolean remove(Object value) {

        if (value == null) {
            for (Node temp = first; temp != null; temp = temp.next) {
                if (temp.data == null) {
                    deleteNode(temp);
                    return true;
                }
            }
        } else {
            for (Node temp = first; temp != null; temp = temp.next) {
                if (value.equals(temp.data)) {
                    deleteNode(temp);
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 删除指定位置的节点
     */
    public Object remove(int index) {
        checkElementIndex(index);
        return deleteNode(currentIndexNode(index));
    }

    /** 
     * 更改指定位置的元素，并返回旧的元素的值
     */
    public Object set(int index, Object value) {

        checkElementIndex(index);

        Node temp = currentIndexNode(index);
        Object oldValue = temp.data;
        temp.data = value;

        return oldValue;
    }

    /** 
     * 打印所有元素
     */
    public void printAll() {
        Node f = first;
        while (f != null) {
            System.out.print(f.data + " ");
            f = f.next;
        }
        System.out.println();
    }

    /**
     * 删除节点
     */
    private Object deleteNode(Node node) {
        Object element = node.data;

        Node prev = node.prev;
        Node next = node.next;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.data = null;
        --size;

        return element;
    }

    /**
     * 越界信息
     */
    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    /**
     * 检查索引是否在元素范围内
     */
    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    /**
     * 检查索引是否符合位置需求
     */
    private void checkPositionIndex(int index) {
        if (!isPositionIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }

    /**
     * 获取当前索引位置的节点
     */
    private Node currentIndexNode(int index) {
        if (index < (size >> 1)) {

            Node temp = first;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }

            return temp;
        } else {
            Node temp = last;

            for (int i = size - 1; i > index; i--) {
                temp = temp.prev;
            }

            return temp;
        }
    }

    private static class Node {

        Node prev; // 上一个节点
        Object data;
        Node next; // 下一个节点

        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }

    }

}