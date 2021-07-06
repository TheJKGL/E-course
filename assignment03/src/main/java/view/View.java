package view;

/**
 * Created by Yevhenii Malakhov 06.07.2021.
 */
public class View {
    public static final String SURNAME = "Enter your surname:";
    public static final String NAME = "Enter your first name:";
    public static final String WRONG_INPUT = "Wrong input please enter in format ";

    public void printMessage(String message) {
        System.out.println(message);
    }
}
