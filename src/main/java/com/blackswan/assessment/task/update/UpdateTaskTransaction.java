package com.blackswan.assessment.task.update;


import com.blackswan.assessment.entity.Task;

public class UpdateTaskTransaction
{
    UpdateTaskGatewayInterface gateway;

    public void updateTask(int userID, int taskID, Task taskDetails)
    {
        taskDetails.userID = userID;
        taskDetails.id = taskID;
        gateway.updateTask(taskDetails);
    }

    public void setGateway(UpdateTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
