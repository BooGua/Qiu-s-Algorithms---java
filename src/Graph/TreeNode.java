package Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class TreeNode {

    private int data;
    private TreeNode left = null;
    private TreeNode right = null;

    public TreeNode(final int data) {
        this(data, null, null);
    }

    public TreeNode(final int data, final TreeNode left, final TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    /**
     * 以此为根节点层序遍历。
     */
    public void PrintLevelOrder() {
        System.out.print("层序输出（非递归）：");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(this);
        while (!deque.isEmpty()) {
            TreeNode tempTreeNode = deque.pop();
            System.out.print(tempTreeNode.data + " ");
            if (tempTreeNode.left != null) {
                deque.add(tempTreeNode.left);
            }
            if (tempTreeNode.right != null) {
                deque.add(tempTreeNode.right);
            }
        }
    }

    /**
     * 以此为根节点先序遍历，递归方法。
     *
     * @param treeNode
     */
    public void PrintPreOrdersRecursion(TreeNode treeNode) {
        System.out.print(treeNode.getData() + " "); // 根节点。
        if (treeNode.getLeft() != null) {
            PrintPreOrdersRecursion(treeNode.getLeft()); // 左孩子。
        }
        if (treeNode.getRight() != null) {
            PrintPreOrdersRecursion(treeNode.getRight()); // 右孩子。
        }
    }

    /**
     * 非递归方法的先序遍历。
     */
    public void PrintPreOrdersNoRe() {
        System.out.print("前序输出（非递归）：");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempTreeNode = this;
        while (tempTreeNode != null || !stack.isEmpty()) {
            if (tempTreeNode != null) {
                System.out.print(tempTreeNode.getData() + " ");
                stack.push(tempTreeNode);
                tempTreeNode = tempTreeNode.getLeft();
            } else {
                tempTreeNode = stack.pop();
                tempTreeNode = tempTreeNode.getRight();
            }
        }
    }

    /**
     * 非递归方法的中序遍历。
     */
    public void PrintInOrderNoRe() {
        System.out.print("中序输出（非递归）：");
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tempTreeNode = this;
        while (tempTreeNode != null || stack.size() > 0) {
            if (tempTreeNode != null) {
                stack.push(tempTreeNode);
                tempTreeNode = tempTreeNode.getLeft();
            } else {
                tempTreeNode = stack.pop();
                System.out.print(tempTreeNode.getData() + " ");
                tempTreeNode = tempTreeNode.getRight();
            }
        }
    }

    /**
     * 后序遍历，非递归。
     */
    public void PrintPostOrderNoRe() {
        System.out.print("后序遍历（非递归）：");
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> output = new Stack<>();
        TreeNode tempTreeNode = this;
        while (tempTreeNode != null || stack.size() > 0) {
            if (tempTreeNode != null) {
                output.push(tempTreeNode);
                stack.push(tempTreeNode);
                tempTreeNode = tempTreeNode.getRight();
            } else {
                tempTreeNode = stack.pop();
                tempTreeNode = tempTreeNode.getLeft();
            }
        }
        while (output.size() > 0) {
            System.out.print(output.pop().getData() + " ");
        }
    }
}
