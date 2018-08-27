package JianZhiOffer;

import org.junit.Test;

/**
 * n 的 m 次方。这里使用了一个递归方法，可以使效率增大。
 */
public class Test16 {

    @Test
    public void test() {
        double n = 5;
        int m = 3;
        double result = MathPower(n, m);
        System.out.println(result);
    }

    private double CoMathPower(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = CoMathPower(base, exponent >> 1);
        result = result * result;
        if (exponent % 2 == 1) {
            result = result * base;
        }
        return result;
    }

    private double MathPower(double base, int exponent) {
        if (Math.abs(base) < 0.00000001 && exponent < 0) {
            System.out.println("输入错误！");
            return 0;
        } else if (Math.abs(base) < 0.00000001) { // base == 0
            return 0;
        } else if (Math.abs(base - 1) < 0.00000001) { // base == 1
            return base;
        } else if (exponent == 0) {
            return 1;
        }

        double result = CoMathPower(base, Math.abs(exponent));
        if (exponent > 1) {
            return result;
        } else {
            return 1 / result;
        }
    }
}
