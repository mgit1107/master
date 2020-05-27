package math;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Calculate {
    public static void main(String[] args) {
        //浮点型计算金额不准确
        float a = 1f;
        float b = 0.9999999999f;
        System.out.println(a==b);

        //使用java.math下自带的大数类可以避免这一问题
        //BigInteger
        BigDecimal c = new BigDecimal(Float.toString(a));
        BigDecimal d = new BigDecimal(Float.toString(b));

        System.out.println(c==d);

        //计算商品金额也可以使用long类型 单位取分
    }
}
