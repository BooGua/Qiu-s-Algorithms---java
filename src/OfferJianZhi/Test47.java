package OfferJianZhi;

import org.junit.Test;

/**
 * 礼物的最大值。
 */
public class Test47 {

    @Test
    public void test() {
        int[][] map = {
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        int max = GetMaxMap(map);
        System.out.println(max);
    }


    private int GetMaxMap(int[][] map) {
        int n = map.length;
        int m = map[0].length;
        int[][] mapValue = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    mapValue[i][j] = map[i][j];
                } else if (i == n - 1) {
                    mapValue[i][j] = map[i][j] + mapValue[i][j + 1];
                } else if (j == m - 1) {
                    mapValue[i][j] = map[i][j] + mapValue[i + 1][j];
                } else {
                    mapValue[i][j] = map[i][j] + (mapValue[i + 1][j] > mapValue[i][j + 1] ? mapValue[i + 1][j] : mapValue[i][j + 1]);
                }
            }
        }
        for (int i = 0; i < mapValue.length; i++) {
            for (int j = 0; j < mapValue[0].length; j++) {
                System.out.print(mapValue[i][j] + " ");
            }
            System.out.println();
        }
        return mapValue[0][0];
    }
}
