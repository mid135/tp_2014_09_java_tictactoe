package base;

import base.UserDataSet;

/**
 * Created by titaevskiy.s on 17.10.14
 */
public interface AccountService {
    ResponsesCode signUp(String login, String email, String password);

    ResponsesCode signIn(String login, String password, String httpSessionId);

    void signOut(String httpSessionId);

    int countSignIn();

    int countSignUp();

    UserDataSet getUserDataSet(String httpSessionId);
}
