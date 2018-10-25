package com.blackswan.assessment.task.retrieve;

import com.blackswan.assessment.entity.Task;


public class RetrieveTaskTransaction
{
    RetrieveTaskGatewayInterface gateway;

    public Task retrieveTask(int userID)
    {
        return gateway.retrieveTask(userID);
    }

    public void setGateway(RetrieveTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
