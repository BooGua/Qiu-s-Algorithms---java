package OfferJianZhi;

import Graph.TreeNode;
import org.junit.Test;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Test27 {
    @Test
    public void test() {
        TreeNode R1 = new TreeNode(1);
        TreeNode r2 = new TreeNode(2);
        TreeNode r3 = new TreeNode(3);
        TreeNode r4 = new TreeNode(4);
        TreeNode r5 = new TreeNode(5);
        TreeNode r6 = new TreeNode(6);
        R1.setLeft(r2);
        R1.setRight(r3);
        r2.setLeft(r4);
        r2.setRight(r5);
        r5.setLeft(r6);
        MirrorTree(R1);

        R1.PrintLevelOrder();
    }

    private void MirrorTree(TreeNode root) {
        if (root == null)
            return;
        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        MirrorTree(root.getLeft());//镜像根节点的左孩子的左右子树
        MirrorTree(root.getRight());//镜像根节点的右孩子的左右子树
    }
}
