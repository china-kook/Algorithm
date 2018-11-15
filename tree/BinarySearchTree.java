/**
 * 二叉查找树
 * 
 * @author ikook
 */
public class BinarySearchTree {

    private Node tree;

    public Node find(int data) {
        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                p = p.left;
            } else if (p.data > data) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    public void insert(int data) {
        if (tree == null) {
            tree = new Node(data);
            return;
        }

        Node p = tree;
        while (p != null) {
            if (p.data < data) {
                if (p.right == null) {
                    p.right = new Node(data);
                    return;
                }
                p = p.right;
            } else { // data < p.data
                if (p.left == null) {
                    p.left = new Node(data);
                    return;
                }
                p = p.left;
            }
        }
    }

    public void delete(int data) {
        Node p = tree; // p 指向要删除的节点，初始化指向根节点
        Node pp = null; // pp 记录的是 p 的父节点

        // 查找到要删除的节点，以及待删除节点的父节点
        while (p != null && p.data != data) {
            pp = p;
            if (data > p.data) {
                p = p.right;
            } else {
                p = p.left;
            }
        }

        if (p == null) {
            return;
        }

        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null) { // 查找右子树上的最小节点
            Node minP = p.right;  // 最小节点
            Node minPP = p;  // 最小节点的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.data = minP.data;
            p = minP;
            pp = minPP;
        }

        // 删除的节点是叶子节点或者仅有一个子节点
        Node child = null;
        if (p.left != null) { // 左子节点不为空
            child = p.left;
        } else if (p.right != null) { // 右子节点不为空
            child = p.right;
        }

        // 进行删除操作
        if (pp == null) { // 没有父节点，证明是根节点
            tree = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }

    }

    public Node findMin() {
        if (tree == null) {
            return null;
        }
        Node p = tree;
        while(p.left != null) {
            p = p.left;
        }
        return p;
    }

    public Node findMax() {
        if(tree == null) {
            return null;
        } 
        Node p = tree;
        while(p.right != null) {
            p = p.right;
        }
        return p;
    }

    public static class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }

}