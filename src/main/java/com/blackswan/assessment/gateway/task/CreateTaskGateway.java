package com.blackswan.assessment.gateway.task;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.task.create.CreateTaskGatewayInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateTaskGateway implements CreateTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public void createTask(Task taskDetail)
    {
        insertIntoTaskTable(taskDetail.name,taskDetail.description,taskDetail.date_time,"pending",taskDetail.userID);
    }

    private static void insertIntoTaskTable(String name,String description,String date_time,String status,int userID)
    {
        String sql = "INSERT INTO task(name,description,date_time,status,user_id) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setString(3, date_time);
            pstmt.setString(4, status);
            pstmt.setInt(5, userID);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }
}
