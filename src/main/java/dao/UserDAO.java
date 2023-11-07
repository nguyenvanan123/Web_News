package dao;

import model.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UserDAO implements IUserDAO{

    private String jdbcURL = "jdbc:mysql://localhost:3306/demo12";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root@123";

    private static final String INSERT_USERS_SQL = "INSERT INTO createposts" + " ( title,  content , access) VALUES " +
            " (?, ?, ?)";


    public UserDAO() {
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
    public void insertContent(User user) throws SQLException{

        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getTitle());
            preparedStatement.setString(2, user.getContent());
//                preparedStatement.setString(3, user.getTimestamp());

//                preparedStatement.setString(4, user.getAvatar());
//                preparedStatement.setString(5, user.getShortdescription());
            preparedStatement.setBoolean(3, user.isAccess());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }


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


}

