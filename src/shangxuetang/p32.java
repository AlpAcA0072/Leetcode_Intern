package shangxuetang;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 在需要精确的小数计算时再使用BigDecimal，BigDecimal的性能比double和float差，在处理庞大，复杂的运算时尤为明显。故一般精度的计算没必要使用BigDecimal。<p>
 * 尽量使用参数类型为String的构造函数。<p>
 * BigDecimal都是不可变的（immutable）的，在进行每一次四则运算时，都会产生一个新的对象，所以在做加减乘除运算时要记得要保存操作后的值。<p>
 * <p>
 * BigInteger也是不可变的，在进行每一步运算时，都会产生一个新的对象。都会产生一个新的对象。发生异常算术条件时，会抛出ArithmeticException异常。例如，一个整数除以“0”，会抛出一个这个类的实例。<p>
 * 假设比较一个int数据平方与另一个大小的问题，很可能会内存溢出。除了使用二分法外，利用BigInteger的compareTo方法也是一个好选择，简单易懂，而且不需要算法支持。<p>
 * 常用的只有：构造函数，基本运算以及compareTo()，intValue()，setBit()，testBit()方法。<p>
 * setBit()和testBit()方法可用于菜单的权限控制。<p>
 */
public class p32 {
    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(1);
        BigDecimal bigDecimal = BigDecimal.valueOf(1.0);

        BigDecimal a = new BigDecimal(0.1);
        System.out.println("a values is:" + a);
        System.out.println("=====================");
        BigDecimal b = new BigDecimal("0.1");
        System.out.println("b values is:" + b);
        System.gc();

        System.out.println(a.compareTo(new BigDecimal("0.1")));
        System.out.println(b.compareTo(new BigDecimal("0.1")));
        System.out.println(a.subtract(new BigDecimal("0.1")));

        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        BigInteger bigInteger1 = in.nextBigInteger();


        String str = "1011100111";
        int radix = 2;
        BigInteger interNum1 = new BigInteger(str, radix); // 743
        // 我们通常不写，则是默认成10进制转换，如下
        BigInteger interNum2 = new BigInteger(str);


    }

    //基本运算:add(),subtract(),multiply(),divide(),mod(),remainder(),pow(),abs(),negate()
    @Test
    public void testBasic() {
        BigInteger a = new BigInteger("13");
        BigInteger b = new BigInteger("4");
        int n = 3;

        //1.加
        BigInteger bigNum1 = a.add(b);            //17
        //2.减
        BigInteger bigNum2 = a.subtract(b);        //9
        //3.乘
        BigInteger bigNum3 = a.multiply(b);        //52
        //4.除
        BigInteger bigNum4 = a.divide(b);        //3
        //5.取模(需 b > 0，否则出现异常：ArithmeticException("BigInteger: modulus not positive"))
        BigInteger bigNum5 = a.mod(b);            //1
        //6.求余
        BigInteger bigNum6 = a.remainder(b);    //1
        //7.平方(需 n >= 0，否则出现异常：ArithmeticException("Negative exponent"))
        BigInteger bigNum7 = a.pow(n);            //2197
        //8.取绝对值
        BigInteger bigNum8 = a.abs();            //13
        //9.取相反数
        BigInteger bigNum9 = a.negate();        //-13
    }


    //比较大小:compareTo(),max(),min()
    @Test
    public void testCompare() {
        BigInteger bigNum1 = new BigInteger("52");
        BigInteger bigNum2 = new BigInteger("27");
        //1.compareTo()：返回一个int型数据（1 大于； 0 等于； -1 小于）
        int num = bigNum1.compareTo(bigNum2);            //1

        //2.max()：直接返回大的那个数，类型为BigInteger
        //	原理：return (compareTo(val) > 0 ? this : val);
        BigInteger compareMax = bigNum1.max(bigNum2);    //52

        //3.min()：直接返回小的那个数，类型为BigInteger
        //	原理：return (compareTo(val) < 0 ? this : val);
        BigInteger compareMin = bigNum1.min(bigNum2);    //27
    }

    //类型转换(返回类型如下)
    @Test
    public void testToAnother() {
        BigInteger bigNum = new BigInteger("52");
        int radix = 2;

        //1.转换为bigNum的二进制补码形式
        byte[] num1 = bigNum.toByteArray();
        //2.转换为bigNum的十进制字符串形式
        String num2 = bigNum.toString();        //52
        //3.转换为bigNum的radix进制字符串形式
        String num3 = bigNum.toString(radix);    //110100
        //4.将bigNum转换为int
        int num4 = bigNum.intValue();
        //5.将bigNum转换为long
        long num5 = bigNum.longValue();
        //6.将bigNum转换为float
        float num6 = bigNum.floatValue();
        //7.将bigNum转换为double
        double num7 = bigNum.doubleValue();
    }

    //二进制运算(返回类型都为BigInteger，不常用，但有备无患)
    @Test
    public void testBinaryOperation() {
        BigInteger a = new BigInteger("13");
        BigInteger b = new BigInteger("2");
        int n = 1;

        //1.与：a&b
        BigInteger bigNum1 = a.and(b);            //0
        //2.或：a|b
        BigInteger bigNum2 = a.or(b);            //15
        //3.异或：a^b
        BigInteger bigNum3 = a.xor(b);            //15
        //4.取反：~a
        BigInteger bigNum4 = a.not();            //-14
        //5.左移n位： (a << n)
        BigInteger bigNum5 = a.shiftLeft(n);    //26
        //6.右移n位： (a >> n)
        BigInteger bigNum6 = a.shiftRight(n);    //6
    }

    //权限控制：setBit(),testBit()
    @Test
    public void testSetAndTest() {
        //1.封装数据(setBit的值需 >= 0，否则出现异常：ArithmeticException("Negative bit address"))
        BigInteger permission = new BigInteger("0");
        BigInteger numBig = permission.setBit(2);
        numBig = numBig.setBit(5);
        numBig = numBig.setBit(13);
        numBig = numBig.setBit(66);
        System.out.println("原理：" + numBig);
        // 原理：73786976294838214692 = 2^2+2^5+2^13+2^66 次方的和；
        // 看！！即使这么大的数也不会溢出，而int最大值只有2147483647；

        //2.取值验证（返回Boolean型）
        boolean flag1 = numBig.testBit(2);        //true
        boolean flag2 = numBig.testBit(5);        //true
        boolean flag3 = numBig.testBit(13);        //true
        boolean flag4 = numBig.testBit(66);        //true
        boolean flag5 = numBig.testBit(27);        //false
    }
}


/**
 * 用于高精确处理常用的数学运算
 */
class ArithmeticUtils {
    //默认除法运算精度
    private static final int DEF_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */

    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).doubleValue();
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1 被加数
     * @param v2 加数
     * @return 两个参数的和
     */
    public static BigDecimal add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2);
    }

    /**
     * 提供精确的加法运算
     *
     * @param v1    被加数
     * @param v2    加数
     * @param scale 保留scale 位小数
     * @return 两个参数的和
     */
    public static String add(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static double sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).doubleValue();
    }

    /**
     * 提供精确的减法运算。
     *
     * @param v1 被减数
     * @param v2 减数
     * @return 两个参数的差
     */
    public static BigDecimal sub(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2);
    }

    /**
     * 提供精确的减法运算
     *
     * @param v1    被减数
     * @param v2    减数
     * @param scale 保留scale 位小数
     * @return 两个参数的差
     */
    public static String sub(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).doubleValue();
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1 被乘数
     * @param v2 乘数
     * @return 两个参数的积
     */
    public static BigDecimal mul(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static double mul(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return round(b1.multiply(b2).doubleValue(), scale);
    }

    /**
     * 提供精确的乘法运算
     *
     * @param v1    被乘数
     * @param v2    乘数
     * @param scale 保留scale 位小数
     * @return 两个参数的积
     */
    public static String mul(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到
     * 小数点以后10位，以后的数字四舍五入
     *
     * @param v1 被除数
     * @param v2 除数
     * @return 两个参数的商
     */

    public static double div(double v1, double v2) {
        return div(v1, v2, DEF_DIV_SCALE);
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示表示需要精确到小数点以后几位。
     * @return 两个参数的商
     */
    public static double div(double v1, double v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指
     * 定精度，以后的数字四舍五入
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 表示需要精确到小数点以后几位
     * @return 两个参数的商
     */
    public static String div(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v1);
        return b1.divide(b2, scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(scale, RoundingMode.HALF_UP).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理
     *
     * @param v     需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static String round(String v, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 取余数
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static String remainder(String v1, String v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.remainder(b2).setScale(scale, RoundingMode.HALF_UP).toString();
    }

    /**
     * 取余数  BigDecimal
     *
     * @param v1    被除数
     * @param v2    除数
     * @param scale 小数点后保留几位
     * @return 余数
     */
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, RoundingMode.HALF_UP);
    }

    /**
     * 比较大小
     *
     * @param v1 被比较数
     * @param v2 比较数
     * @return 如果v1 大于v2 则 返回true 否则false
     */
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        if (bj > 0)
            res = true;
        else
            res = false;
        return res;
    }
}
