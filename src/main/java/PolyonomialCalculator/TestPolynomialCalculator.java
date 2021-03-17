
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestPolynomialCalculator {
    @Test
    public void TestPolynomialCalculator() {
        List<Monomial> monomials1 = new ArrayList<>();
        monomials1.add(new Monomial(2, 3));
        monomials1.add(new Monomial(-5, 1));
        monomials1.add(new Monomial(7, 0));

        Polynomial pol1 = new Polynomial(monomials1, 3);

        List<Monomial> monomials2 = new ArrayList<>();
        monomials2.add(new Monomial(1, 1));
        monomials2.add(new Monomial(-2, 0));

        Polynomial pol2 = new Polynomial(monomials2, 1);

        assertTrue(pol1.add(pol2).toString().equals("+2.0*x^3-4.0*x^1+5.0*x^0"));
        assertTrue(pol1.sub(pol2).toString().equals("+2.0*x^3-6.0*x^1+9.0*x^0"));
        assertTrue(pol1.mul(pol2).toString().equals("+2.0*x^4-4.0*x^3-5.0*x^2+17.0*x^1-14.0*x^0"));
        assertTrue(pol1.deriv().toString().equals("+6.0*x^2-5.0*x^0"));
        assertTrue(pol1.integ().toString().equals("+0.5*x^4-2.5*x^2+7.0*x^1"));
        //assertTrue(pol1.div(pol2).toString().equals("+2.0*x^2+4.0*x^1+3.0*x^0"));
    }
}
