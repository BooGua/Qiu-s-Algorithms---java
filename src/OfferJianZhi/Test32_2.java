package OfferJianZhi;

import Graph.TreeNode;

import java.util.ArrayList;

/**
 * 分行从上到下打印二叉树。
 */
public class Test32_2 {

    // 层次遍历打印二叉树
    public ArrayList<Integer> printFromTopToButtom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        // 层次遍历树和图都需要一个队列，这儿用一个ArrayList实现 queue的数据逻辑
        // 用LinkedList更好，它实现了Queue接口 可以调用 队列的 add offer element peek poll等方法
        // 并且基本都是添加删除操作，效率会好一些
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return null;

        queue.add(root);
        while (queue.size() != 0) {
            TreeNode tmp = queue.remove(0);
            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
            }
            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
            }
            list.add(tmp.getData());
        }
        return list;
    }

    public void printTreeSplitRow(TreeNode root) {
        ArrayList<TreeNode> queue = new ArrayList<>();
        if (root == null)
            return;
        queue.add(root);
        // 分别记录当前行未打印个数 以及下一行需要打印的个数
        int nextLevel = 0, toBePrint = 1;

        while (!queue.isEmpty()) {
            TreeNode tmp = queue.get(0);
            System.out.print(tmp.getData() + " ");

            if (tmp.getLeft() != null) {
                queue.add(tmp.getLeft());
                nextLevel++;
            }

            if (tmp.getRight() != null) {
                queue.add(tmp.getRight());
                nextLevel++;
            }

            queue.remove(0);
            toBePrint--;
            if (toBePrint == 0) {
                // 当前行打印完毕
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }

    }

    // 之字形打印二叉树 各行 从左往右 从右往左 交替打印
    public void printTree(TreeNode root) {
        if (root == null)
            return;
        // 按照这个要求我们需要两个栈辅助
        // 交替使用两个栈 奇数层数据存放在stack1 偶数层在stack2
        // 奇数层我们把下一层数据先left后right压入stack2 偶数层把下一层先right后left压入stack1
        // 这样就可以实现隔层之字形打印
        ArrayList<TreeNode> stack1 = new ArrayList<>();
        ArrayList<TreeNode> stack2 = new ArrayList<>();
        // 用一个flag标记 当前是奇数层还是偶数层
        boolean flag = true;
        TreeNode tmp = null;
        stack1.add(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (flag) {
                tmp = stack1.get(stack1.size() - 1);
                stack1.remove(stack1.size() - 1);
            } else {
                tmp = stack2.get(stack2.size() - 1);
                stack2.remove(stack2.size() - 1);
            }

            System.out.print(tmp.getData() + " ");

            if (flag) {
                if (tmp.getLeft() != null) {
                    stack2.add(tmp.getLeft());
                }
                if (tmp.getRight() != null) {
                    stack2.add(tmp.getRight());
                }
            } else {
                if (tmp.getRight() != null) {
                    stack1.add(tmp.getRight());
                }
                if (tmp.getLeft() != null) {
                    stack1.add(tmp.getLeft());
                }
            }

            // 当前层打印完毕 换行 并更改flag的值
            if (flag) {
                if (stack1.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            } else {
                if (stack2.isEmpty()) {
                    System.out.println();
                    flag = !flag;
                }
            }
        }
    }
}
