import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

import p.a;
import p.b;

public class Test extends a{
    public static void main(String[] args) {
        // Test t=new Test();
        // b s=new b();
        BigInteger bt=new BigInteger("32132");
        long s=bt.longValue();
        System.out.println(s);
        bt=bt.pow(10);
        System.out.println(bt);
        BigDecimal bd=new BigDecimal("1");
        bd=bd.divide(new BigDecimal("9"),1000,BigDecimal.ROUND_HALF_UP);
        System.out.println(bd.toString());
        System.out.println(new BigDecimal("2").sqrt(new MathContext(1000)));
    }
}