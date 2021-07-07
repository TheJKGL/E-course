package view;

import java.util.Locale;
import java.util.ResourceBundle;

import static view.TextConstant.*;

/**
 * Created by Yevhenii Malakhov 06.07.2021.
 */
public class View {
    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));        // English

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printStringInput(String message) {
        printMessage(bundle.getString(INPUT) + bundle.getString(message));
    }

    public void printWrongInput(String message) {
        printMessage(bundle.getString(WRONG_INPUT) + bundle.getString(message));
    }
}
