import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ArithmeticsTest {

    private static Arithmetics arithmetics;
    private final double delta = 1e-9;

    @BeforeClass
    public static void init() {
        arithmetics = new Arithmetics();
    }

    @Test
    public void testAdd() {
        double result = arithmetics.add(-10, 20);
        Assert.assertEquals(10, result, delta);
    }

    @Test
    public void testDeduct() {
        double result = arithmetics.deduct(-10, 20);
        Assert.assertEquals(-30, result, delta);
    }

    @Test
    public void testMultiply() {
        double result = arithmetics.multiply(-10, 20);
        Assert.assertEquals(-200, result, delta);
    }

    @Test
    public void testDivide() {
        double result = arithmetics.divide(45, 5);
        Assert.assertEquals(9, result, delta);
    }

    @Test(expected = ArithmeticException.class)
    public void zeroDividingThrowException() {
        arithmetics.divide(7,0);
    }
}