package com.blackswan.assessment.gateway.task;


import com.blackswan.assessment.task.delete.DeleteTaskGatewayInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteTaskGateway implements DeleteTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public void deleteTask(int userID,int taskID)
    {
        deleteTaskFromTable(userID,taskID);
    }

    private void deleteTaskFromTable(int userID,int taskID)
    {
        String sql = "DELETE FROM user WHERE id = ? AND user_id ?;";
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, taskID);
            pstmt.setInt(2, userID);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error deleting data");
        }
    }
}
