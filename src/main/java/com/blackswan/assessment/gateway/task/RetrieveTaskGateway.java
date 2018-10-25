package com.blackswan.assessment.gateway.task;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.task.retrieve.RetrieveTaskGatewayInterface;

import java.sql.*;

public class RetrieveTaskGateway implements RetrieveTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public Task retrieveTask(int userID, int taskID)
    {
        return retrieveTaskFromTable(userID, taskID);
    }

    private Task retrieveTaskFromTable(int userID, int taskID)
    {
        String sql = "SELECT id, name, description, date_time, status, user_id FROM task WHERE user_id = ? AND id = ?;";
        Task taskDetails = new Task();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, userID);
            pstmt.setInt(2, taskID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                taskDetails.id = rs.getInt("id");
                taskDetails.name = rs.getString("name");
                taskDetails.description = rs.getString("description");
                taskDetails.date_time = rs.getString("date_time");
                taskDetails.status = rs.getString("status");
                taskDetails.userID = rs.getInt("user_id");
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
        return taskDetails;
    }
}
