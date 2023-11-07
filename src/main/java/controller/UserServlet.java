package controller;

import dao.IUserDAO;
import dao.UserDAO;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", urlPatterns = "/users")

public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IUserDAO userDAO = new IUserDAO() {
        @Override
        public void insertContent(User user) throws SQLException {

        }
    };

    public void init() {
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertContent(request, response);
                    break;

            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {

            case "create":
                showNewForm(request, response);
                break;

            default:
                break;

        }

    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/createposts.jsp");
        dispatcher.forward(request, response);
    }
    private void insertContent(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String title = request.getParameter("title");
//            String timestamp = request.getParameter("timestamp");
        String content = request.getParameter("content");
//            String avatar = request.getParameter("avatar");
//            String shortdescription = request.getParameter("shortdescription");
        boolean access = Boolean.parseBoolean(request.getParameter("access"));
        User newUser = new User();
        newUser.setTitle(title);
        newUser.setContent(content);
//            newUser.setTimestamp(timestamp);
        newUser.setAccess(access);
        userDAO.insertContent(newUser);
        response.sendRedirect("home.jsp");




    }




}
