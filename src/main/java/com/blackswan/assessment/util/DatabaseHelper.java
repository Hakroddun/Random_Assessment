package com.blackswan.assessment.util;

import java.sql.*;

public class DatabaseHelper
{
    private static String url = "jdbc:sqlite:./assessment.db";

    public static void createTables()
    {
        createUserTable();
        createTaskTable();
    }

    private static void createUserTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS user (id integer PRIMARY KEY, username text NOT NULL UNIQUE, first_name text NOT NULL, last_name text NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    private static void createTaskTable()
    {
        String sql = "CREATE TABLE IF NOT EXISTS task (id integer PRIMARY KEY, name text NOT NULL UNIQUE, description text, date_time text NOT NULL, status text NOT NULL, user_id integer NOT NULL);";

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement())
        {
            stmt.execute(sql);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static void populateTables()
    {
        insertIntoUserTable("kFischer","Kaylum","Fischer");
        insertIntoUserTable("aJustice","Adeel","Justice");
        insertIntoUserTable("cHickman","Cole","Hickman");
        insertIntoUserTable("kBannister","Kyran","Bannister");

        insertIntoTaskTable("Task1","Dummy Task1","2018-10-23 09:29:00","pending",1);
        insertIntoTaskTable("Task2","Dummy Task2","2018-10-23 09:29:00","pending",1);
        insertIntoTaskTable("Task3","Dummy Task3","2018-10-23 09:29:00","pending",2);
        insertIntoTaskTable("Task4","Dummy Task4","2018-10-23 09:29:00","pending",2);
        insertIntoTaskTable("Task5","Dummy Task5","2018-10-23 09:29:00","pending",3);
        insertIntoTaskTable("Task6","Dummy Task6","2018-10-23 09:29:00","pending",3);
        insertIntoTaskTable("Task7","Dummy Task7","2018-10-23 09:29:00","pending",4);
        insertIntoTaskTable("Task8","Dummy Task8","2018-10-23 09:29:00","pending",4);
    }

    //Could be used to migrate data
    public static void insertIntoUserTable(String username,String first_name,String last_name)
    {
        String sql = "INSERT OR REPLACE INTO user(username,first_name,last_name) VALUES(?,?,?)";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, username);
            pstmt.setString(2, first_name);
            pstmt.setString(3, last_name);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }

    //Could be used to migrate data
    public static void insertIntoTaskTable(String name,String description,String date_time,String status,int user_ID)
    {
        String sql = "INSERT OR REPLACE INTO task(name,description,date_time,status,user_id) VALUES(?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setString(3, date_time);
            pstmt.setString(4, status);
            pstmt.setInt(5, user_ID);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.err.println("Error inserting data");
        }
    }
}
