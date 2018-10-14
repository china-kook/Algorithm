package linkedlist;

/**
 * SinglyLinkedList 单链表的插入、删除、查找操作  
 * > 注：链表中的数据为 int 类型         
 * 
 * @author ikook
 */
public class SinglyLinkedList {

    Node head = null;
    
    public void insert(int value) {
        Node newNode = createNode(value);
        if(head == null) {
            head = newNode;
            return;
        }
        
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        
        p.next = newNode;
        
    }

    public void insertToHead(int value) {
        Node newNode = createNode(value);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = createNode(value);
        insertAfter(p, newNode);
    }

    public void insertAfter(Node p, Node newNode) {
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = createNode(value);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) {
            return;
        }

        if (head == p) {
            insertToHead(newNode);
            return;
        }

        Node q = head;

        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        newNode.next = p; // p == q.next;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;

        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;

        while (p != null && p.item != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

    }

    public Node findByValue(int value) {
        Node p = head;

        while (p != null && p.item != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;

        while (p != null && pos != index) {
            p = p.next;
            ++pos;
        }

        return p;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {

        private int item;
        private Node next;

        public Node(int element, Node next) {
            this.item = element;
            this.next = next;
        }
        
        public int getData() {
            return item;
        }

    }

}
