package com.blackswan.assessment.gateway.task;

import com.blackswan.assessment.entity.User;
import com.blackswan.assessment.user.retrieve.RetrieveUserGatewayInterface;

import java.sql.*;

public class RetrieveTaskGateway implements RetrieveUserGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public User retrieveUser(int userID)
    {
        return retrieveUserFromTable(userID);
    }

    private User retrieveUserFromTable(int userID)
    {
        String sql = "SELECT id, username, first_name, last_name FROM user WHERE id = ?;";
        User userDetails = new User();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                userDetails.id = rs.getInt("id");
                userDetails.username = rs.getString("username");
                userDetails.first_name = rs.getString("first_name");
                userDetails.last_name = rs.getString("last_name");
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
        return userDetails;
    }
}
