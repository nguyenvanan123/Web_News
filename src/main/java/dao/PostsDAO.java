package dao;

import model.Posts;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class PostsDAO implements IPostsDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/RegisterUser";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";

    private static final String INSERT_CREATEPOSTS_SQL = "INSERT INTO createposts" + " ( title,  content , timestamp, avatar, shortdescription, access) VALUES " +
            " (?, ?, ?, ?, ?, ?)";

    private static final String SELECT_ALL_CREATEPOSTS = "select * from createposts";

    private static final String DELETE_USERS_SQL = "delete from createposts where id = ?;";

    private static final String UPDATE_USERS_SQL = "update createposts set title = ?,content= ?, avatar =? , shortdescription=? , access=? where id = ?;";

    public PostsDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertContent(Posts user) throws SQLException {

        System.out.println(INSERT_CREATEPOSTS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CREATEPOSTS_SQL)) {
            preparedStatement.setString(1, user.getTitle());
            preparedStatement.setString(2, user.getContent());
            preparedStatement.setString(3, user.getTimestamp());

            preparedStatement.setString(4, user.getAvatar());
            preparedStatement.setString(5, user.getShortdescription());
            preparedStatement.setBoolean(6, user.isAccess());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Posts selectPosts(int id) {
        return null;
    }


    @Override
    public List<Posts> selectAllPosts() {


        List<Posts> posts = new ArrayList<>();
        try (Connection connection = getConnection();


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CREATEPOSTS);) {
            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String content = rs.getString("content");

                String timestamp = rs.getString("timestamp");
                String avatar = rs.getString("avatar");
                String shortdescription = rs.getString("shortdescription");
                boolean access = rs.getBoolean("access");
                posts.add(new Posts(id, title, content, timestamp, avatar, shortdescription, access));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return posts;
    }


    @Override
    public boolean updatePosts(Posts posts) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, posts.getTitle());
            statement.setString(2, posts.getContent());
            statement.setString(3, posts.getAvatar());
            statement.setString(4, posts.getShortdescription());
            statement.setBoolean(5, posts.isAccess());
            statement.setInt(6, posts.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    @Override
    public boolean deletePosts(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Posts> search(String keyword) throws SQLException {
        List<Posts> postsList = new ArrayList<>();
Connection connection = getConnection();
CallableStatement cs = connection.prepareCall( " select * from createposts where content like ? or title like ?;");
    cs.setString(1,"%" + keyword + "%");
    cs.setString(2,"%" + keyword + "%");
    ResultSet rs = cs.executeQuery();

    while (rs.next()){
        int id = rs.getInt("id");
        String title = rs.getString("title");
        String content = rs.getString("content");

        String timestamp = rs.getString("timestamp");
        String avatar = rs.getString("avatar");
        String shortdescription = rs.getString("shortdescription");
        boolean access = rs.getBoolean("access");
        postsList.add(new Posts(id, title, content, timestamp, avatar, shortdescription, access));
    }
    return postsList;
    }


//public boolean searchUser(Posts posts) {
//     Connection connection = getConnection();

    //
//    return false;
//}
    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public static void main(String[] args) {
        PostsDAO postsDAO = new PostsDAO();
        List<Posts> posts = postsDAO.selectAllPosts();
        for (Posts post : posts) {
            System.out.println(post);
        }

    }
}
