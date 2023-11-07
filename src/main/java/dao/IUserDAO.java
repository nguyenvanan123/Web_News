package dao;

import model.User;

import java.sql.SQLException;

public interface IUserDAO {
    public void insertContent(User user) throws SQLException;

}
