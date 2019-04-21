
import java.math.BigDecimal;
import java.math.MathContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Krizz2ND
 */
public class test {
    public static void main(String[] args) {
        BigDecimal v;
        BigDecimal c;
        BigDecimal d;
        int a = 10;
        int b = 10;
        v = new BigDecimal(a);
        c = new BigDecimal(b);
        d = v.multiply(c);
        System.out.println("HASIL NYAAA BOOOIIII : "+d);
        
    }
}
