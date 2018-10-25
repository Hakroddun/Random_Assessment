package com.blackswan.assessment.task.delete;

public class DeleteTaskTransaction
{
    DeleteTaskGatewayInterface gateway;

    public void deleteTask(int userID,int taskID)
    {
        gateway.deleteTask(userID,taskID);
    }

    public void setGateway(DeleteTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
