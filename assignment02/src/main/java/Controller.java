import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Yevhenii Malakhov 30.06.2021.
 */
public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * This method reads input data and returns it.
     *
     * @return input value.
     */
    public String readInputValue() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Main method.This method starts the program
     * and does all the necessary actions.
     */
    public void processUser() {
        model.setBarriers(GlobalConstants.MIN_BARRIER, GlobalConstants.MAX_BARRIER);
        model.setSecretValue();

        view.printMessage(View.SECRET_IS + model.getSecretValue());
        view.printMessage(createInputMessage());

        //Read input value.
        int inputValue = Integer.parseInt(readInputValue());

        //Working with data and processing the game.
        while (!model.isWin(inputValue)) {
            if (isInputValueCorrect(inputValue)) {
                model.replaceRange(inputValue);
                view.printMessage(createInputMessage());
            } else {
                view.printMessage(View.WRONG_INPUT + createInputMessage());
            }
            inputValue = Integer.parseInt(readInputValue());
        }
        view.printMessage(View.CONGRATULATION + model.getSecretValue());
        view.printMessage(View.YOUR_WAY + model.getUserWay());
    }

    /**
     * This method check input value.
     *
     * @param value input data.
     * @return result of checking.
     */
    public boolean isInputValueCorrect(int value) {
        return value >= model.getMinBarrier() && value <= model.getMaxBarrier();
    }

    /**
     * This method creates input message at the begging.
     *
     * @return message.
     */
    public String createInputMessage() {
        return View.INPUT_DATA +
                View.OPENS_SQUARE_BRACKET +
                model.getMinBarrier() +
                View.SPACE +
                model.getMaxBarrier() +
                View.CLOSING_SQUARE_BRACKET +
                " = ";
    }
}
