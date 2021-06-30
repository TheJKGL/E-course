package assignment2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public String readInputValue(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        view.printMessage(View.INPUT_DATA);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void processUser(){
        int inputValue = Integer.parseInt(readInputValue());


    }


}
