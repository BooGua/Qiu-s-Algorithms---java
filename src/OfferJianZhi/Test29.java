package OfferJianZhi;

import org.junit.Test;

/**
 * 顺时针打印矩阵。
 */
public class Test29 {
    @Test
    public void test() {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        PrintMatrix(matrix);
    }

    private void PrintMatrix(int[][] matrix) {
        int n = matrix[0].length; // 5
        int m = (n + 1) / 2; // 3
        int x = 0, y = 0;
        for (int i = 0; i < m; i++) {
            for (int j = y; j < n - y; j++) {
                System.out.print(matrix[x][j] + " ");
            }
            for (int j = x + 1; j < n - x; j++) {
                System.out.print(matrix[j][n - y - 1] + " ");
            }
            for (int j = n - y - 2; j >= x; j--) {
                System.out.print(matrix[n - x - 1][j] + " ");
            }
            for (int j = n - x - 2; j > y; j--) {
                System.out.print(matrix[j][x] + " ");
            }
            x++;
            y++;
        }
    }
}
