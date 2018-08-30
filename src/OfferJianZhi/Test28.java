package OfferJianZhi;

import Graph.TreeNode;
import org.junit.Test;

/**
 * 对称的二叉树。
 */
public class Test28 {

    @Test
    public void test() {

    }

    boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    boolean isSymmetrical(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return true;
        if (r1 == null || r2 == null)
            return false;
        return r1.getData() == r2.getData() && isSymmetrical(r1.getLeft(), r2.getRight())
                && isSymmetrical(r1.getRight(), r2.getLeft());
    }

}
