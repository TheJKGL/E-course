package controller;

import model.entity.DBNoteBook;
import model.entity.NotUniqueLoginException;

/**
 * Created by Yevhenii Malakhov 06.07.2021.
 */
public class InputData {
    private String firstName;
    private String login;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLogin(String login) throws NotUniqueLoginException {
        if (DBNoteBook.checkLogin(login)) {
            throw new NotUniqueLoginException("Not unique login", login);
        }
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLogin() {
        return login;
    }
}
