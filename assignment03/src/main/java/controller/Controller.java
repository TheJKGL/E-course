package controller;

import model.Model;
import model.entity.NotUniqueLoginException;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static controller.RegexConstant.*;
import static model.entity.DBNoteBook.checkLogin;
import static view.TextConstant.*;

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
        String regex = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_NAME_UKR : REGEX_NAME_LAT;

        String firstName = checkInputData(regex, NAME);
        inputData.setFirstName(firstName);

        String login = checkInputData(REGEX_LOGIN, LOGIN);
        while (true) {
            try {
                inputData.setLogin(login);
                break;
            } catch (NotUniqueLoginException e) {
                e.printStackTrace();
                view.printMessage(e.getMessage() + " " + e.getLoginData());
                login = checkInputData(REGEX_LOGIN, LOGIN);
            }
        }

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
        view.printStringInput(message);
        String enteredData = readInputData();
        while (!enteredData.matches(regex)) {
            view.printWrongInput(message);
            enteredData = readInputData();
        }
        return enteredData;
    }

    public void showResult(InputData inputData) {
        view.printMessage("Register information:");
        view.printMessage(inputData.getFirstName());
        view.printMessage(inputData.getLogin());
    }
}
