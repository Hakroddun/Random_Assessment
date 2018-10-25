package com.blackswan.assessment.gateway.user;

import com.blackswan.assessment.entity.User;
import com.blackswan.assessment.user.list.ListUserGatewayInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListUserGateway implements ListUserGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public List<User> listUsers()
    {
        return retrieveUsersFromTable();
    }

    private List<User> retrieveUsersFromTable()
    {
        String sql = "SELECT id, username, first_name, last_name FROM user;";
        List<User> userList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                User userDetails = new User();
                userDetails.id = rs.getInt("id");
                userDetails.username = rs.getString("username");
                userDetails.first_name = rs.getString("first_name");
                userDetails.last_name = rs.getString("last_name");
                userList.add(userDetails);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
        return userList;
    }
}
