package com.blackswan.assessment.gateway.task;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.task.list.ListTaskGatewayInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListTaskGateway implements ListTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public List<Task> listTasks(int userID)
    {
        return retrieveTasksFromTable(userID);
    }

    private List<Task> retrieveTasksFromTable(int userID)
    {
        String sql = "SELECT id, name, description, date_time, status, user_id FROM task WHERE user_id = ?;";
        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, userID);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Task taskDetails = new Task();
                taskDetails.id = rs.getInt("id");
                taskDetails.name = rs.getString("name");
                taskDetails.description = rs.getString("description");
                taskDetails.date_time = rs.getString("date_time");
                taskDetails.status = rs.getString("status");
                taskDetails.userID = rs.getInt("user_id");
                taskList.add(taskDetails);
            }
        }
        catch (SQLException e)
        {
            System.err.println("Error retrieving data");
        }
        return taskList;
    }
}
