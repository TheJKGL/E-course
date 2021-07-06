package controller;

import model.Model;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static controller.RegexConstant.*;

/**
 * Created by Yevhenii Malakhov 06.07.2021.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        InputData inputData = new InputData();
        String firstName = checkInputData(REGEX_NAME_LAT, View.NAME);
        inputData.setFirstName(firstName);

        String surname = checkInputData(REGEX_NAME_LAT, View.SURNAME);
        inputData.setSurname(surname);

        showResult(inputData);
    }

    public String readInputData() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * This method check data with the special regex,
     * and return correct input data.
     *
     * @param regex   regex constant.
     * @param message output message.
     * @return correct data.
     */
    public String checkInputData(String regex, String message) {
        view.printMessage(message);
        String enteredData = readInputData();
        while (!enteredData.matches(regex)) {
            view.printMessage(View.WRONG_INPUT + regex + " :");
            enteredData = readInputData();
        }
        return enteredData;
    }

    public void showResult(InputData inputData) {
        view.printMessage("Register information:");
        view.printMessage(inputData.getFirstName());
        view.printMessage(inputData.getSurname());
    }
}
