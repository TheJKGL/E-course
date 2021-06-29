package assignment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

    public Model model;
    public  View view;

    public Controller(Model model,View view) {
        this.model = model;
        this.view = view;
    }

    public String readInputData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        view.printMessage(View.ENTER_DATA);
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String checkData(String template){
        String firstWord = readInputData();
        while (!firstWord.equals(template)){
            view.printMessage(View.WRONG_INPUT_DATA);
            firstWord = readInputData();
            view.printMessage("Great!Enter please next word)");
        }
        return firstWord;
    }

    public void processor(){
        model.setFirstWord(checkData(View.FIRST_WORD));
        model.setSecondWord(checkData(View.SECOND_WORD));
    }
}
