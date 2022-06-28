package Repos;

import Models.User;
import Utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public User getUserById(int user_id){
        String sql = "select * from users where user_id = ?;";

        try(Connection connect = cu.getConnection()){
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new User(rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("pword"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByUsername(String username){
        String sql = "select * from users where username = ?;";

        try(Connection connect = cu.getConnection()){
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new User(rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("pword"));
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
