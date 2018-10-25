package com.blackswan.assessment.gateway.user;

import com.blackswan.assessment.entity.User;
import com.blackswan.assessment.user.update.UpdateUserGatewayInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserGateway implements UpdateUserGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public void updateUser(User userDetail)
    {
        updateRecordInUserTable(userDetail.id,userDetail.first_name,userDetail.last_name);
    }

    private void updateRecordInUserTable(int userID, String first_name, String last_name)
    {
        String sql = "UPDATE user SET first_name = ?, last_name = ? WHERE id = ?;";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setInt(3, userID);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }
}
