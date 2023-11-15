package controller;

import dao.IPostsDAO;
import dao.PostsDAO;
import model.Posts;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "PostsServlet", urlPatterns = "/posts")

public class PostsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IPostsDAO postsDAO;

    public void init() {
        postsDAO = new PostsDAO();
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
                case "edit":
                    updatePost(request, response);
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

        try {
            switch (action) {
                case "create":
                    showNewForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deletePosts(request, response);
                    break;
////                case "list":
////                    listUser(request, response);
////                    break;
                default:
                    listPosts(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    private void listPosts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Posts> listPosts = postsDAO.selectAllPosts();
        request.setAttribute("listPosts", listPosts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/list.jsp");
        dispatcher.forward(request, response);
    }



    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/create.jsp");
        dispatcher.forward(request, response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Posts existingUser = postsDAO.selectPosts(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/edit.jsp");
        request.setAttribute("p", existingUser);
        dispatcher.forward(request, response);

    }
    private void insertContent(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String timestamp = request.getParameter("timestamp");

        String avatar = request.getParameter("avatar");
        String shortdescription = request.getParameter("shortdescription");
        boolean access = Boolean.parseBoolean(request.getParameter("access"));
        Posts newUser = new Posts();
        newUser.setTitle(title);
        newUser.setContent(content);
        newUser.setTimestamp(timestamp);
        newUser.setAvatar(avatar);
        newUser.setShortdescription(shortdescription);
//            newUser.setTimestamp(timestamp);
        newUser.setAccess(access);
        postsDAO.insertContent(newUser);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("post.jsp");
        request.setAttribute("insertContent", newUser);
        requestDispatcher.forward(request,response);
    }



    private void updatePost(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String avatar = request.getParameter("avatar");
        String shortdescription = request.getParameter("shortdescription");
        boolean access = Boolean.parseBoolean(request.getParameter("access"));




        Posts book = new Posts( id, title, content,avatar, shortdescription, access);
        postsDAO.updatePosts(book);


        RequestDispatcher dispatcher = request.getRequestDispatcher("posts/edit.jsp");
        dispatcher.forward(request, response);

    }
    private void deletePosts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        postsDAO.deletePosts(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("posts?action=listPosts");
        dispatcher.forward(request, response);

    }

}
