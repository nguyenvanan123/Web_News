package dao;

import model.Posts;

import java.sql.SQLException;
import java.util.List;

public interface IPostsDAO {
    public void insertContent(Posts user) throws SQLException;

    Posts selectPosts(int id);


    List<Posts> selectAllPosts();

    public boolean updatePosts(Posts posts) throws SQLException;

    public boolean deletePosts(int id) throws SQLException;
     public List<Posts> search (String keyword) throws SQLException;

}
