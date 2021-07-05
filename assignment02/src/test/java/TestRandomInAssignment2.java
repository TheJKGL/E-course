import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRandomInAssignment2 {

    public static Model model;
    public static  View view;
    public static  Controller controller;

    @BeforeClass
    public static void init() {
        model = new Model();
        view = new View();
        controller = new Controller(model, view);
        model.setBarriers(GlobalConstants.MIN_BARRIER, GlobalConstants.MAX_BARRIER);
        model.setSecretValue();
    }

    @Test
    public void testRandNotEqual100(){
        for(int i = 0; i < 10000000; i++){
            int randValue = model.getSecretValue();
            Assert.assertNotEquals(randValue,100);
        }
    }

    @Test
    public void testRandNotEqual0(){
        for(int i = 0; i < 10000000; i++){
            int randValue = model.getSecretValue();
            Assert.assertNotEquals(randValue,0);
        }
    }

    @Test
    public  void testRange(){
        for(int i = 0; i < 10000000; i++){
            int randValue = model.getSecretValue();
            boolean isCorrect = randValue > model.getMinBarrier()
                    && randValue < model.getMaxBarrier();
            Assert.assertTrue(isCorrect);
        }
    }
}
