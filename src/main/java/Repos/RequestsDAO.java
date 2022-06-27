package Repos;

import Models.Requests;
import Utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RequestsDAO {
    private static ConnectionUtil cu = ConnectionUtil.getConnectionUtil();

    public Requests createRequest(int user_id, String employee_first_name,
                                  String employee_last_name, String request_date, String request_time, int trainingType,
                                  String description, float request_cost, String request_justification,
                                  int gradeType){
        String sql = "insert into requests values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, default, default) returning *;";

        try(Connection connect = cu.getConnection()){
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.setString(2, employee_first_name);
            ps.setString(3, employee_last_name);
            ps.setString(4, request_date);
            ps.setString(5, request_time);
            ps.setInt(6, trainingType);
            ps.setString(7, description);
            ps.setFloat(8, request_cost);
            ps.setString(9, request_justification);
            ps.setInt(10, gradeType);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                return new Requests( rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getString("employee_first_name"),
                        rs.getString("employee_last_name"),
                        rs.getString("request_date"),
                        rs.getString("request_time"),
                        rs.getInt("trainingtype"),
                        rs.getString("description"),
                        rs.getFloat("request_cost"),
                        rs.getString("request_justification"),
                        rs.getInt("gradetype"),
                        rs.getInt("status"),
                        rs.getString("proof")
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Requests> getAllRequests(){
        String sql = "select * from requests";

        try(Connection connect = cu.getConnection()){
            PreparedStatement ps = connect.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            List<Requests> allRequests = new ArrayList<>();
            while(rs.next()){
                Requests r = new Requests(rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getString("employee_first_name"),
                        rs.getString("employee_last_name"),
                        rs.getString("request_date"),
                        rs.getString("request_time"),
                        rs.getInt("trainingtype"),
                        rs.getString("description"),
                        rs.getFloat("request_cost"),
                        rs.getString("request_justification"),
                        rs.getInt("gradetype"),
                        rs.getInt("status"),
                        rs.getString("proof"));
                allRequests.add(r);
            }
            return allRequests;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<Requests> getRequestsByUserId(int user_id){
        String sql = "select * from requests where user_id = ?;";

        try(Connection connect = cu.getConnection()){
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setInt(1, user_id);

            ResultSet rs = ps.executeQuery();

            List<Requests> allRequests = new ArrayList<>();
            while(rs.next()){
                Requests r = new Requests(rs.getInt("request_id"),
                        rs.getInt("user_id"),
                        rs.getString("employee_first_name"),
                        rs.getString("employee_last_name"),
                        rs.getString("request_date"),
                        rs.getString("request_time"),
                        rs.getInt("trainingtype"),
                        rs.getString("description"),
                        rs.getFloat("request_cost"),
                        rs.getString("request_justification"),
                        rs.getInt("gradetype"),
                        rs.getInt("status"),
                        rs.getString("proof"));
                allRequests.add(r);
            }
            return allRequests;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}