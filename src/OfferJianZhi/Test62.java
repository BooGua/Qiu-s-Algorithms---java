package OfferJianZhi;

import javafx.scene.shape.Circle;
import org.junit.Test;

/**
 * 圆圈中最后剩下的数字。约瑟夫环问题。
 */
public class Test62 {
    @Test
    public void test() {
        CircleNode circleNode = new CircleNode(0);
        int n = 4000, m = 997;
        YueSeFuHuan(circleNode, n);
//        PrintCircleNode(circleNode, 20);
        circleNode = YueSeFuHuanDelete(circleNode, m);
        System.out.println(circleNode.data);
        System.out.println("使用公式：" + cir(4001, 997));
    }

    private CircleNode YueSeFuHuanDelete(CircleNode circleNode, int m) {
        CircleNode temp = circleNode;
        while (temp.next != temp) {
            for (int i = 0; i < m - 2; i++) {
                temp = temp.next;
            }
            temp.deletNext();
            temp = temp.next;
        }
        return temp;
    }

    private void PrintCircleNode(CircleNode circleNode, int n) {
        CircleNode temp = circleNode;
        for (int i = 0; i < n; i++) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    private void YueSeFuHuan(CircleNode circleNode, int n) {
        CircleNode circleNodeTemp = circleNode;
        for (int i = 1; i <= n; i++) {
            CircleNode circleN = new CircleNode(i);
            circleNodeTemp.next = circleN;
            circleNodeTemp = circleN;
        }
        circleNodeTemp.next = circleNode;
    }

    private class CircleNode {
        int data;
        CircleNode next;

        public CircleNode(int data) {
            this.data = data;
        }

        public void deletNext() {
            CircleNode temp = this.next;
            this.next = temp.next;
            System.out.println("[" + temp.data + "]");
            temp.next = null;
        }
    }

    //////////////////////////////////////////
    ///////////////公式
    //////////////////////////////////////////

    int cir(int n, int m) {
        int p = 0;
        for (int i = 2; i <= n; i++) {
            p = (p + m) % i;
        }
        return p + 1;
    }
}
