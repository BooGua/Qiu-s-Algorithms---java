package Graph;

import org.junit.Test;

import java.util.Arrays;

/**
 * 已知前序、中序求二叉树。
 */
public class PreOrdersAndInOrders {

    private TreeNode buildTree(int[] preOrders, int[] inOrders) {
        if (preOrders.length == 0 || inOrders.length == 0) {
            return null;
        }
        TreeNode tree = new TreeNode(preOrders[0]);
        int index = search(0, inOrders.length, inOrders, tree.getData());
        tree.setLeft(buildTree(Arrays.copyOfRange(preOrders, 1, index + 1), Arrays.copyOfRange(inOrders, 0, index)));
        tree.setRight(buildTree(Arrays.copyOfRange(preOrders, index + 1, preOrders.length),
                Arrays.copyOfRange(inOrders, index + 1, inOrders.length)));
        return tree;
    }

    private static int search(int start, int end, int[] inOrders, int data) {
        for (int i = start; i < end; i++) {
            if (data == inOrders[i]) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void ceShiXianXuHouXu() {
        int[] preOrders = new int[]{1, 2, 4, 8, 5, 3, 6, 7};
        int[] inOrders = new int[]{8, 4, 2, 5, 1, 6, 3, 7};

        TreeNode treeNode = buildTree(preOrders, inOrders); // 根据前序、中序生成树。
        treeNode.PrintLevelOrder(); // 层序输出。
        System.out.println();
        System.out.print("前序输出（递归）：");
        treeNode.PrintPreOrdersRecursion(treeNode); // 前序输出。（递归方法）
        System.out.println();
        treeNode.PrintPreOrdersNoRe(); // 前序输出。（非递归方法）
        System.out.println();
        treeNode.PrintInOrderNoRe(); // 中序输出。（非递归方法）
        System.out.println();
        treeNode.PrintPostOrderNoRe(); // 后序输出。（非递归方法）
    }
}