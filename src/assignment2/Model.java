package assignment2;

import java.util.ArrayList;

public class Model {
    private int minBarrier;
    private int maxBarrier;

    private int secretValue;

    private ArrayList<Integer> userWay = new ArrayList<>();

    public void setSecretValue(){
        //secretValue = (int)Math.ceil(Math.random() * (maxBarrier - minBarrier - 1) + minBarrier);
        secretValue = minBarrier + (int)(Math.random() * maxBarrier);
    }

    public void setBarriers(int min,int max){
        this.minBarrier = min;
        this.maxBarrier = max;
    }
}
