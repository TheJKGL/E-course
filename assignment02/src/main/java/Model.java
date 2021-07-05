import java.util.ArrayList;

/**
 * Created by Yevhenii Malakhov 30.06.2021.
 */
public class Model {
    private int minBarrier;
    private int maxBarrier;

    private int secretValue;

    private final ArrayList<Integer> userWay = new ArrayList<>();

    public void setSecretValue() {
        //secretValue = (int)Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
        secretValue = minBarrier + (int) (Math.random() * maxBarrier);
    }

    public void setBarriers(int min, int max) {
        this.minBarrier = min;
        this.maxBarrier = max;
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public ArrayList<Integer> getUserWay() {
        return userWay;
    }

    /**
     * This method change the range depending on input data.
     *
     * @param value input data.
     */
    public void replaceRange(int value) {
        userWay.add(value);
        if (value > secretValue) {
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
    }

    /**
     * This method check if game is win or continues.
     *
     * @param value input data.
     * @return result of check.
     */
    public boolean isWin(int value) {
        return value == secretValue;
    }
}
