package com.blackswan.assessment.task.create;

import com.blackswan.assessment.entity.Task;

public class CreateTaskTransaction
{
    CreateTaskGatewayInterface gateway;

    public void createTask(int userID, Task taskDetails)
    {
        taskDetails.userID = userID;
        gateway.createTask(taskDetails);
    }

    public void setGateway(CreateTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
