package OfferJianZhi;

import Graph.TreeNode;
import org.junit.Test;

import java.util.ArrayList;

/**
 * 题目：输入一棵二叉树和整数，打印出二叉树中节点值得和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 解题思路：路径从根节点开始，应该用类似于前序遍历的方式访问树节点。我们需要整个路径，就需要一个容器保存经过路径上的节点，
 * 以及一个变量记录当前已有节点元素的和。当前序遍历到某一个节点时，添加该节点到路径，累加节点值。
 * 如果该节点为叶子节点并节点值累计等于目标整数，则找到一条路径。如果不是叶子节点，则继续访问子节点。
 * 一个节点访问结束后，递归函数自动回到其父节点。
 */
public class Test34 {
    // pathList存所有可能路径
    // path用来保存路径的数据结构 这儿用ArrayList模拟了栈的数据结构
    private ArrayList<ArrayList<Integer>> pathList = new ArrayList<ArrayList<Integer>>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int sum) {
        if (root == null)
            return pathList;
        path.add(root.getData());
        sum -= root.getData();
        // 路径值等于0，且当前节点是叶子节点 则找到一条路径
        if (sum == 0 && root.getLeft() == null && root.getRight() == null)
            // 每次找到路径都需要添加一个新的path 不可以直接加path成员变量 这是个引用，不然所有pathList的值都指向同一个path
            pathList.add(new ArrayList<Integer>(path));
        if (root.getLeft() != null)
            findPath(root.getLeft(), sum);

        if (root.getRight() != null)
            findPath(root.getRight(), sum);
        // 访问完当前节点 需要删除路径中最后一个节点，回退至父节点
        path.remove(path.size() - 1);
        return pathList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        Test34 p34 = new Test34();
//        System.out.println(p34.pathList);
        p34.findPath(node1, 22);
        for (ArrayList<Integer> list : p34.pathList) {
            for (int i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    ///////////////////////////////////////////////////////////////////////
    ///////////////// 从这里开始是我写的代码 //////////////////////////////
    ////////// 一定要注意不能直接放 path，因为是引用，会被不断更改 ////////
    ///////////////////////////////////////////////////////////////////////

    @Test
    public void test() {
        TreeNode r5 = new TreeNode(5, new TreeNode(4), new TreeNode(7));
        TreeNode root = new TreeNode(10, r5, new TreeNode(12));
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        PrintSum(root, results, new ArrayList<Integer>(), 22, 0);
        for (int i = 0; i < results.size(); i++) {
            System.out.println(results.get(i));
        }
    }

    private void PrintSum(TreeNode root, ArrayList<ArrayList<Integer>> results, ArrayList<Integer> path, int totalSum, int sum) {
        sum = sum + root.getData();
        if (sum <= totalSum) {
            path.add(root.getData());
            if (root.getLeft() == null && root.getRight() == null) {
                if (sum == totalSum) {
                    results.add(path);
                }
            }
            if (root.getLeft() != null) {
                ArrayList<Integer> arrayList_1 = new ArrayList<>();
                arrayList_1.addAll(path);
                PrintSum(root.getLeft(), results, arrayList_1, totalSum, sum);
            }
            if (root.getRight() != null) {
                ArrayList<Integer> arrayList_2 = new ArrayList<>();
                arrayList_2.addAll(path);
                PrintSum(root.getRight(), results, arrayList_2, totalSum, sum);
            }
        }
    }
}
