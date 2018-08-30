package OfferJianZhi;

import Graph.TreeNode;
import org.junit.Test;

/**
 * 树的子结构。
 */
public class Test26 {

    @Test
    public void test() {
//        int[] preOrders = {1, 2, 4, 5, 3};
//        int[] inOrders = {4, 2, 5, 1, 3};
//        TreeNode R1M = new PreOrdersAndInOrders().buildTree(preOrders, inOrders);
//
//        int[] preOrders2 = {2, 4, 5};
//        int[] inOrders2 = {4, 2, 5};
//        TreeNode R2M = new PreOrdersAndInOrders().buildTree(preOrders2, inOrders2);

        TreeNode R1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        R1.setLeft(r2);
        R1.setRight(r3);
        r2.setLeft(r4);
        r2.setRight(r5);

        TreeNode R2 = new TreeNode(2);
        TreeNode r2_4 = new TreeNode(4);
        TreeNode r2_5 = new TreeNode(5);
        R2.setLeft(r2_4);
        R2.setRight(r2_5);

        boolean result = IsSonTree(R1, R2);
        System.out.println(result);
    }

    private boolean IsSonTree(TreeNode r1, TreeNode r2) {
        boolean result = false;
        if (r1 != null && r2 != null) {
            if (r1.getData() == r2.getData()) {
                result = MySonTree(r1, r2);
            }
            if (!result) {
                result = IsSonTree(r1.getLeft(), r2);
            }
            if (!result) {
                result = IsSonTree(r1.getRight(), r2);
            }
        }
        return result;
        /*
        Deque<TreeNode> deque = new LinkedList<>();
        ArrayList<TreeNode> arrayList = new ArrayList<>();
        deque.add(r1);
        while (!deque.isEmpty()) {
            TreeNode tempTreeNode = deque.pop();
            arrayList.add(tempTreeNode);
            if (tempTreeNode.getLeft() != null) {
                deque.add(tempTreeNode.getLeft());
            }
            if (tempTreeNode.getRight() != null) {
                deque.add(tempTreeNode.getRight());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            boolean flag = MySonTree(arrayList.get(i), r2);
            if (flag) {
                return true;
            }
        }
        return false;
        */
    }

    private boolean MySonTree(TreeNode r1, TreeNode r2) {
        if (r2 == null) {
            return true;
        }
        if (r1 == null) { // r1 为空，r2 不为空，一定不是。
            return false;
        }
        if (r1.getData() != r2.getData()) {
            return false;
        }

        return MySonTree(r1.getLeft(), r2.getLeft()) && MySonTree(r1.getRight(), r2.getRight());
    }
}
