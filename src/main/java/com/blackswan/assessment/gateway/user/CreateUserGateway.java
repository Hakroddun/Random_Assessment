package com.blackswan.assessment.gateway.user;

import com.blackswan.assessment.entity.User;
import com.blackswan.assessment.user.create.CreateUserGatewayInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateUserGateway implements CreateUserGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public void createUser(User userDetail)
    {
        insertIntoUserTable(userDetail.username,userDetail.first_name,userDetail.last_name);
    }

    private void insertIntoUserTable(String username,String first_name,String last_name)
    {
        String sql = "INSERT INTO user(username,first_name,last_name) VALUES(?,?,?);";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, username);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        } catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }
}
