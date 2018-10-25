package com.blackswan.assessment.gateway.task;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.task.update.UpdateTaskGatewayInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTaskGateway implements UpdateTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public void updateTask(Task taskDetail)
    {
        updateRecordInTaskTable(taskDetail.id, taskDetail.name, taskDetail.userID);
    }

    private void updateRecordInTaskTable(int taskID, String name, int userID)
    {
        String sql = "UPDATE task SET name = ? WHERE id = ? AND user_id = ?;";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setInt(2, taskID);
            pstmt.setInt(3, userID);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }
}
