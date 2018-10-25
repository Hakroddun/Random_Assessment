package com.blackswan.assessment.entity;

public class Task
{
    public int id;
    public String name;
    public String description;
    public String date_time;
    public String status;
    public int userID;

    @Override
    public String toString()
    {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", date_time='" + date_time + '\'' +
                ", status='" + status + '\'' +
                ", userID=" + userID +
                '}';
    }
}
