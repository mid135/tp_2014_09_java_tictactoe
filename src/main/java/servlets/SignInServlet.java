package servlets;

import base.AccountService;
import base.PageUrlServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author s.titaevskiy on 14.09.14.
 */
public class SignInServlet extends HttpServlet implements PageUrlServlet {
    public static final String pageURL = "/signin";
    private final AccountService accountService;

    public SignInServlet(AccountService accountService) {
        this.accountService = accountService;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        String responseAnswer;
        switch (accountService.signIn(login, password, request.getSession().getId())) {
            case OK:
                responseAnswer = "The user " + login + " signin";
                break;
            case WRONG_SIGNIN:
                responseAnswer = "Enter correct login and password";
                break;
            default:
                responseAnswer = "Unknown error";
                break;
        }

        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(responseAnswer);
    }

    @Override
    public String getPageUrl() {
        return pageURL;
    }
}