package com.blackswan.assessment.task.retrieve;

import com.blackswan.assessment.entity.Task;


public class RetrieveTaskTransaction
{
    private RetrieveTaskGatewayInterface gateway;

    public Task retrieveTask(int userID,int taskID)
    {
        return gateway.retrieveTask(userID,taskID);
    }

    public void setGateway(RetrieveTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
