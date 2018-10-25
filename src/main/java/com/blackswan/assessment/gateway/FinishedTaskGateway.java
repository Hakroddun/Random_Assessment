package com.blackswan.assessment.gateway;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.scheculedJob.FinishedTaskGatewayInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FinishedTaskGateway implements FinishedTaskGatewayInterface
{
    private static String url = "jdbc:sqlite:./assessment.db";

    @Override
    public List<Task> getFinishedTasks()
    {
        return retrieveTasksFromTable();
    }

    private List<Task> retrieveTasksFromTable()
    {
        String sql = "SELECT id, name, description, date_time, status, user_id FROM task WHERE status <> ? AND strftime('%s',date_time)<=strftime('%s','now','localtime');";
        List<Task> taskList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, "done");
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

    @Override
    public void updateFinishedTasks(List<Task> tasksToUpdate)
    {
        String idsToUpdate = createStringOfTaskIDs(tasksToUpdate);
        updateRecordInTaskTable(idsToUpdate,"done");
    }

    private String createStringOfTaskIDs(List<Task> tasksToUpdate)
    {
        String ids = "";
        for(int i = 0; i < tasksToUpdate.size(); i++)
        {
            ids = ids.concat(Integer.toString(tasksToUpdate.get(i).id));
            if(i < tasksToUpdate.size()-1)
            {
                ids = ids.concat(",");
            }
        }
        return ids;
    }

    private void updateRecordInTaskTable(String taskID, String status)
    {
        String sql = "UPDATE task SET status = ? WHERE id IN ("+taskID+");";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, status);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error updating data");
        }
    }
}
